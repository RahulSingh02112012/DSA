package Tree.Zalando;

public class CodilityQuestion2 {

    // Paint skyline on the wall of room question

    public static void main(String[] args) {
        System.out.println(getSkyline(new int[]{1,3,2,1,2,1,5,3,3,4,2}));
        System.out.println(getSkyline(new int[]{5,8}));
        System.out.println(getSkyline(new int[]{1,1,1,1}));

    }

    private static int getSkyline(int[] A) {
        int brushCnt = 0;
        int prevHeight =0;

        for(int i=0; i<A.length;i++) {
            if(A[i]> prevHeight) {
                brushCnt = brushCnt + (A[i]-prevHeight);
            }
            prevHeight = A[i];
        }
        //return brushCnt;
        return brushCnt < 1000000000 ? brushCnt : -1;
    }
}
