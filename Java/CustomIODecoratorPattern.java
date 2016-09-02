import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomIODecoratorPattern {

	public static void main(final String[] args) {
		int c;
		try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(
				new FileInputStream(new File("test.txt"))))) {
			while ((c = in.read()) > 0) {
				System.out.print((char) c);
			}
		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}
}

class LowerCaseInputStream extends FilterInputStream {

	protected LowerCaseInputStream(final InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		final int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char) c));
	}

	@Override
	public int read(final byte[] b, final int offset, final int len)
			throws IOException {
		final int result = super.read(b, offset, len);
		for (int i = offset; i < offset + result; i++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
	}
}
