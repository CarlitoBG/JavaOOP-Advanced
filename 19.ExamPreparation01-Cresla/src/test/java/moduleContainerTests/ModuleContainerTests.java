package moduleContainerTests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

public class ModuleContainerTests {

    private AbsorbingModule absorbingModule1;
    private AbsorbingModule absorbingModule2;
    private EnergyModule energyModule1;
    private EnergyModule energyModule2;
    private Container container;

    @Before
    public void before(){
        this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        this.energyModule1 = Mockito.mock(EnergyModule.class);
        this.energyModule2 = Mockito.mock(EnergyModule.class);
        this.container = new ModuleContainer(3);

        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(absorbingModule2.getHeatAbsorbing()).thenReturn(2_000_000_000);

        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(2_000_000_000);

        Mockito.when(absorbingModule1.getId()).thenReturn(1);
        Mockito.when(absorbingModule2.getId()).thenReturn(2);
        Mockito.when(energyModule1.getId()).thenReturn(3);
        Mockito.when(energyModule2.getId()).thenReturn(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAsParameterAtEnergyModuleShouldThrowIllegalArgumentException(){
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAsParameterAtAbsorbingModuleShouldThrowIllegalArgumentException(){
        this.container.addAbsorbingModule(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void tryAddModuleOnContainerWithZeroSizeShouldThrowNoSuchElementException(){
        this.container = new ModuleContainer(0);
        this.container.addAbsorbingModule(this.absorbingModule1);
    }

    @Test
    public void tryAddModuleOverModuleCapacitySizeShouldRemoveOldestModuleCorrectly(){
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);

        Assert.assertEquals(2_000_000_000L, this.container.getTotalHeatAbsorbing());
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
    }

    @Test
    public void absorbingModuleWorksWithLongAsParameterCorrectly(){
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);

        Assert.assertEquals(4_000_000_000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void emptyModuleShouldReturnZeroAsOutput(){

        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
        Assert.assertEquals(0, this.container.getTotalEnergyOutput());
    }
}