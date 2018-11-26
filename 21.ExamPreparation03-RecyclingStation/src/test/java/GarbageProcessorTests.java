import fakeClassesForTests.FakeDisposable;
import fakeClassesForTests.FakeDisposableWaste;
import fakeClassesForTests.FakeNonDisposableWasteWithAnnotation;
import fakeClassesForTests.FakeNonDisposableWasteWithoutAnnotation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.GarbageProcessor;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.StrategyHolder;
import wasteDisposal.models.miscellaneous.DefaultGarbageProcessor;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarbageProcessorTests {

    private final Map<Class, GarbageDisposalStrategy> strategies = new LinkedHashMap<>();

    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolderMock;
    private GarbageDisposalStrategy garbageDisposalStrategyMock;
    private ProcessingData processingDataMock;

    @Before
    public void initialize() {
        this.strategyHolderMock = Mockito.mock(StrategyHolder.class);
        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolderMock);
        this.garbageDisposalStrategyMock = Mockito.mock(GarbageDisposalStrategy.class);
        this.processingDataMock = Mockito.mock(ProcessingData.class);
        this.strategies.put(FakeDisposable.class, this.garbageDisposalStrategyMock);
    }

    @Test
    public void getStrategyHolderShouldReturnHolderSuccessfullyIfPresent() {
        Assert.assertEquals(this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullAsStrategyHolderShouldThrowIllegalArgumentException() {
        this.garbageProcessor = new DefaultGarbageProcessor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessWasteMethodWithNonDisposableGarbageShouldThrowIllegalArgumentException() {
        this.garbageProcessor.processWaste(new FakeNonDisposableWasteWithAnnotation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessWasteMethodWithNonAnnotatedGarbageShouldThrowIllegalArgumentException() {
        this.garbageProcessor.processWaste(new FakeNonDisposableWasteWithoutAnnotation());
    }

    @Test
    public void testProcessWasteMethodWithValidDisposableGarbageShouldReturnProcessingDataObjectSuccessfully() {
        Mockito.when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(this.strategies);
        Mockito.when(this.garbageDisposalStrategyMock.processGarbage(Mockito.isA(FakeDisposableWaste.class)))
                .thenReturn(this.processingDataMock);

        ProcessingData actual = this.garbageProcessor.processWaste(new FakeDisposableWaste());

        Assert.assertEquals(this.processingDataMock, actual);
    }
}