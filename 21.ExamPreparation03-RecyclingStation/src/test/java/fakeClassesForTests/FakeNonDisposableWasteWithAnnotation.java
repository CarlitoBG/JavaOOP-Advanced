package fakeClassesForTests;

import wasteDisposal.contracts.Waste;

@FakeNonDisposable
public class FakeNonDisposableWasteWithAnnotation implements Waste {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getVolumePerKg() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}