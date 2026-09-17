public class GenericClass {

    static final int hash(Object key) {
        int h;
        h = key.hashCode();
        System.out.println("h value: "+ h);
        System.out.println(h >> 16);
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    public static void main(String[] args) {
        String t = "java";
        int hash = hash(t);

        int bucket = hash & (15);
        System.out.println("bucket value: "+ bucket);
        System.out.println("hash of the string: "+ hash);
    }
}
