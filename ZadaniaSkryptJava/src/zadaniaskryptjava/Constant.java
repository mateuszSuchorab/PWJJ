package zadaniaskryptjava;

class Constant extends TreeVertex {

    private int value;

    public Constant(int value) {
        this.value = value;

    }

    @Override
    public int value() {
        return value;
    }

}
