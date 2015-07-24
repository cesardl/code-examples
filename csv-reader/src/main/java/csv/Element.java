package csv;

/**
 *
 * @author Cesardl
 */
public class Element {

    private final String chemicalName;
    private final String symbol;
    private final String atomNum;
    private final String atomWeight;

    private final String boilPoint;
    private final String meltPoint;
    private final String density;

    public static class Builder {

        // Required parameters
        private final String chemicalName;
        private final String symbol;
        private final String atomNum;

        // Optional parameters - initialized to default values
        private String atomWeight;
        private String boilPoint;
        private String meltPoint;
        private String density;

        public Builder(String chemicalName, String symbol, String atomNum) {
            this.chemicalName = chemicalName;
            this.symbol = symbol;
            this.atomNum = atomNum;
        }

        public Builder atomWeight(String val) {
            if (!val.isEmpty()) {
                atomWeight = val;
            }
            return this;
        }

        public Builder boilPoint(String val) {
            if (!val.isEmpty()) {
                boilPoint = val;
            }
            return this;
        }

        public Builder meltPoint(String val) {
            if (!val.isEmpty()) {
                meltPoint = val;
            }
            return this;
        }

        public Builder density(String val) {
            if (!val.isEmpty()) {
                density = val;
            }
            return this;
        }

        public Element build() {
            return new Element(this);
        }
    }

    private Element(Builder builder) {
        this.chemicalName = builder.chemicalName;
        this.symbol = builder.symbol;
        this.atomNum = builder.atomNum;
        this.atomWeight = builder.atomWeight;
        this.boilPoint = builder.boilPoint;
        this.meltPoint = builder.meltPoint;
        this.density = builder.density;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getCanonicalName());
        sb.append("[ Chemical name: ");
        sb.append(chemicalName);
        sb.append(", Symbol: ");
        sb.append(symbol);
        sb.append(", Atom num: ");
        sb.append(atomNum);

        if (atomWeight != null) {
            sb.append(", Atom weight: ");
            sb.append(atomWeight);
        }
        if (boilPoint != null) {
            sb.append(", Boil point: ");
            sb.append(boilPoint);
        }
        if (meltPoint != null) {
            sb.append(", Melt point: ");
            sb.append(meltPoint);
        }
        if (density != null) {
            sb.append(", Density: ");
            sb.append(density);
        }

        sb.append(" ]");
        return sb.toString();
    }
}
