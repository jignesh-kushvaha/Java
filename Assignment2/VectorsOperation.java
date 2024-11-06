public class VectorsOperation {
    private double x;
    private double y;
    private double z;

    public VectorsOperation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public VectorsOperation add(VectorsOperation ob) {
        return new VectorsOperation(this.x + ob.x, this.y + ob.y, this.z + ob.z);
    }
    public VectorsOperation sub(VectorsOperation ob) {
        return new VectorsOperation(this.x - ob.x, this.y - ob.y, this.z - ob.z);
    }

    public void showData() {
        System.out.println("Vector data: (" + x + ", " + y + ", " + z + ")");
    }

    public String toString() {
        return "VectorsOperation(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        VectorsOperation vob1 = new VectorsOperation(10, 20, 30);
        VectorsOperation vob2 = new VectorsOperation(40, 50, 60);

        VectorsOperation addResult = vob1.add(vob2);
        addResult.showData();
        
        VectorsOperation subResult = vob1.sub(vob2);
        System.out.println(subResult);
       
    }
}
