//package practice;
//
///**
// * Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.
//
//
//
// Method read4:
//
// The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.
//
// The return value is the number of actual characters read.
//
// Note that read4() has its own file pointer, much like FILE *fp in C.
//
// Definition of read4:
//
// Parameter:  char[] buf
// Returns:    int
//
// Note: buf[] is destination not source, the results from read4 will be copied to buf[]
// Below is a high level example of how read4 works:
//
// File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
// char[] buf = new char[4]; // Create buffer with enough space to store characters
// read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
// read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
// read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
//
//
// Method read:
//
// By using the read4 method, implement the method read that reads n characters from the file and store it in the buffer array buf. Consider that you cannot manipulate the file directly.
//
// The return value is the number of actual characters read.
//
// Definition of read:
//
// Parameters:	char[] buf, int n
// Returns:	int
//
// Note: buf[] is destination not source, you will need to write the results to buf[]
// */
//public class ReadNCharacters {
////    public class ReadNCharacters extends Reader4 {
//
//    int beg = 0;
//    int end = 0;
//    char[] inner = new char[4];
//
//    /**
//     * @param buf Destination buffer
//     * @param n   Number of characters to read
//     * @return    The number of actual characters read
//     */
//    public int read(char[] buf, int n) {
//        int m = 0;
//        while (m<n) {
//            if (beg == end) {
//                end = read4(inner);
//                beg=0;
//                if (end == 0) {
//                    return m;
//                }
//            }
//            buf[m++] = inner[beg++];
//        }
//        return m;
//    }
//
//}
