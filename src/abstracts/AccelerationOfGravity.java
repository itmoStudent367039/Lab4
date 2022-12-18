package abstracts;

public enum AccelerationOfGravity {
    EARTHGRAVITY(10),
    MOONGRAVITY(3);
    private int value;
    AccelerationOfGravity(int value) {
        this.value = value;
    }
    public int getValueOfGravity() {
        return value;
    }


}
