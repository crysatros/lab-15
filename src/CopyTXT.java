import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Date;
    class CopyTXT {
        double copy (String src, String dst, int buffSize) throws InvalidPathException
        {
            Date strt = new Date();
            Path srcp = Paths.get(src);
            Path dstp = Paths.get(dst);
            long srcSize;
            long dstSize = 0;
            ByteBuffer buffer = ByteBuffer.allocate(buffSize);
            try(SeekableByteChannel srcChan = Files.newByteChannel(srcp); SeekableByteChannel dstChan = Files.newByteChannel(dstp, StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
                srcSize = Files.size(srcp);
                int currBufSize;
                do {
                    currBufSize = srcChan.read(buffer);
                    buffer.rewind();
                    dstChan.write(buffer);
                    dstSize += buffer.position();
                    buffer.rewind();

                    System.out.println("File copy progress: " + ((double)dstSize / (double)srcSize)*100+" %");
                }
                while (currBufSize > 0);
            }
            catch (IOException e)
            {
            }

            Date end = new Date();
            return (double)(end.getTime() - strt.getTime())/1000;
        }
}
