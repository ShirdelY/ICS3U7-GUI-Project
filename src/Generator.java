public class Generator {
    private int length;

    Generator(int length) throws Exception {
        this.length = length;
        if (length != 5 || length != 7)
        {
            throw new Exception("Invalid length");
        }
        
    }

}
