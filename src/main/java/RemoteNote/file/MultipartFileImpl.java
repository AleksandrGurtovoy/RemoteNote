package RemoteNote.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class MultipartFileImpl implements MultipartFile, Serializable {
    private byte[] aByte;
    private String sName;
    private String sContentType;
    private String sOriginalFilename;
    private long nSize;

    public MultipartFileImpl(byte[] aByte, String sName, String sOriginalFilename, String sContentType) {
        this.aByte = aByte;
        this.sName = sName;
        this.sContentType = sContentType;
        this.sOriginalFilename = sOriginalFilename;
        this.nSize = aByte == null ? 0 : aByte.length;
    }

    @Override
    public String getName() {
        return sName;
    }

    @Override
    public String getOriginalFilename() {
        return sOriginalFilename;
    }

    @Override
    public String getContentType() {
        return sContentType;
    }

    @Override
    public boolean isEmpty() {
        return nSize == 0;
    }

    @Override
    public long getSize() {
        return nSize;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return aByte;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(aByte);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(aByte);
    }
}
