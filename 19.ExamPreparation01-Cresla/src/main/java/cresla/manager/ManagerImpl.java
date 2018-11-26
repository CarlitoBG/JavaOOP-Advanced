package cresla.manager;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;
import cresla.interfaces.Module;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reactor.CryoReactor;
import cresla.models.reactor.HeatReactor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<Integer, Reactor> reactorMap;
    private Map<Integer, Module> moduleMap;
    private int id;
    private int energyModulesCounter;
    private int absorbingModulesCounter;
    private int cryoReactorCounter;
    private int heatReactorCounter;


    public ManagerImpl() {
        this.reactorMap = new HashMap<>();
        this.moduleMap = new HashMap<>();
        this.id = 1;
        this.energyModulesCounter = 0;
        this.absorbingModulesCounter = 0;
        this.cryoReactorCounter = 0;
        this.heatReactorCounter = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Container container = new ModuleContainer(Integer.valueOf(arguments.get(2)));
        if("Cryo".equalsIgnoreCase(arguments.get(0))) {
            this.reactorMap.put(this.id, new CryoReactor(container, this.id, Integer.valueOf(arguments.get(1))));
            this.cryoReactorCounter++;
        } else {
            this.reactorMap.put(this.id, new HeatReactor(container, this.id, Integer.valueOf(arguments.get(1))));
            this.heatReactorCounter++;
        }
        return "Created " + arguments.get(0) + " Reactor - " + this.id++;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.valueOf(arguments.get(0));
        switch (arguments.get(1)) {
            case "CryogenRod":
                EnergyModule cryogenRodModule = new CryogenRod(this.id, Integer.valueOf(arguments.get(2)));
                this.reactorMap.get(reactorId).addEnergyModule(cryogenRodModule);
                this.moduleMap.put(this.id, cryogenRodModule);
                this.energyModulesCounter++;
                break;
            case "HeatProcessor":
                AbsorbingModule heatProcessorModule = new HeatProcessor(this.id, Integer.valueOf(arguments.get(2)));
                this.reactorMap.get(reactorId).addAbsorbingModule(heatProcessorModule);
                this.moduleMap.put(this.id, heatProcessorModule);
                this.absorbingModulesCounter++;
                break;
            case "CooldownSystem":
                AbsorbingModule cooldownSystemModule = new CooldownSystem(this.id, Integer.valueOf(arguments.get(2)));
                this.reactorMap.get(reactorId).addAbsorbingModule(cooldownSystemModule);
                this.moduleMap.put(this.id, cooldownSystemModule);
                this.absorbingModulesCounter++;
                break;
            default:
                break;
        }
        return "Added " + arguments.get(1) + " - " + this.id++ + " to Reactor - " + reactorId;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int targetId = Integer.valueOf(arguments.get(0));
        if(reactorMap.containsKey(targetId)) {
            return reactorMap.get(targetId).toString();
        } else {
            return moduleMap.get(targetId).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergy = this.reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalEnergyOutput()).sum();
        long totalHeat = this.reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();

        return "Cryo Reactors: " + this.cryoReactorCounter + System.lineSeparator() +
                "Heat Reactors: " + this.heatReactorCounter + System.lineSeparator() +
                "Energy Modules: " + this.energyModulesCounter + System.lineSeparator() +
                "Absorbing Modules: " + this.absorbingModulesCounter + System.lineSeparator() +
                "Total Energy Output: " + totalEnergy + System.lineSeparator() +
                "Total Heat Absorbing: " + totalHeat;
    }
}
