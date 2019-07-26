//package MockInterview;
//
//public class ReverseBitsof32bitInteger {
//    // https://app.laicode.io/app/mock-interview/5057/626
//
//    public long reverseBits(long n) {
//        long l = 1;
//        long r = (int)Math.pow(2, 31);
//        while ( l != r ) {
//            swap(n, l, r);
//            l = l << 1;
//            r = r >> 1;
//        }
//        return n;
//    }
//
//    private void swap(long l, long r, long n) {
//        // prob
//        long lBit = l & n;
//        long rBit = r & n;
//        // set
//
//    }
//}
