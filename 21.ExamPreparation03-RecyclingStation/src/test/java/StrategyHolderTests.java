import fakeClassesForTests.FakeDisposable;
import fakeClassesForTests.FakeNonDisposable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.StrategyHolder;
import wasteDisposal.models.miscellaneous.DefaultStrategyHolder;

import java.util.Map;

public class StrategyHolderTests {

    private StrategyHolder strategyHolder;
    private GarbageDisposalStrategy mockedStrategy;
    private Class disposableAnnotationClass;
    private Class nonDisposableAnnotationClass;

    @Before
    public void initialize() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.mockedStrategy = Mockito.mock(GarbageDisposalStrategy.class);
        this.disposableAnnotationClass = FakeDisposable.class;
        this.nonDisposableAnnotationClass = FakeNonDisposable.class;
    }

    @Test
    public void testGetDisposalStrategiesAfterInitializationShouldReturnEmptyCollection() {

        int expectedSizeOfStrategyCollection = 0;
        int actual = this.strategyHolder.getDisposalStrategies().size();

        Assert.assertEquals("Operation returned incorrect result!", expectedSizeOfStrategyCollection, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tryingToAddStrategyOnUnmodifiableCollectionShouldThrowUnsupportedOperationException() {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        strategies.put(this.disposableAnnotationClass, this.mockedStrategy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryingToAddStrategyWithNonDisposableAnnotationAsKeyShouldThrowIllegalArgumentException() {
        this.strategyHolder.addStrategy(this.nonDisposableAnnotationClass, this.mockedStrategy);
    }

    @Test
    public void tryingToAddAnAlreadyExistingStrategyShouldReturnFalseAsResult() {
        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);

        boolean actual = this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);

        Assert.assertEquals("Operation returned incorrect result!",false, actual);
    }

    @Test
    public void testAddStrategyMethodWithValidParamsShouldIncreaseStrategiesSizeByOneSuccessfully() {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);

        int expectedSizeOfStrategiesCollection = 1;
        int actual = strategies.size();

        Assert.assertEquals("Strategies count did not match!",expectedSizeOfStrategiesCollection, actual);
    }

    @Test
    public void testAddStrategyMethodWithValidParamsShouldAddExpectedStrategySuccessfully() {
        Map<Class,GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.mockedStrategy);

        GarbageDisposalStrategy expected = this.mockedStrategy;
        GarbageDisposalStrategy actual = strategies.get(this.disposableAnnotationClass);

        Assert.assertEquals("Expected strategy did not match!", expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryingToRemoveStrategyWithNonDisposableAnnotationShouldThrowIllegalArgumentException() {
        this.strategyHolder.removeStrategy(this.nonDisposableAnnotationClass);
    }

    @Test
    public void tryingToRemoveNotAddedStrategyFromStrategyHolderShouldReturnFalseAsResult() {
        boolean actual = this.strategyHolder.removeStrategy(this.disposableAnnotationClass);

        Assert.assertEquals("Operation returned incorrect result!", false, actual);
    }
}