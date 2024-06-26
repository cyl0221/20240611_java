package p08_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ex01Byte {
  public static void main(String[] args) {
    byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
    byte[] outSrc = null;

    //InputStream 은 프로세스 안으로 들어오는 것
    //OutputStream 은 프로세스 밖으로 나가는 것

    ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.out.println(Arrays.toString(inSrc));

    int data;  // = 0; 와일문이 들어가니까 초기화를 하지 않아도됨
    while ((data= input.read())!= -1) {
      output.write(data); //총 10번의 스트림(stream) 생성
    }
    outSrc = output.toByteArray();
    System.out.println(Arrays.toString(outSrc));

    byte[] tmp = new byte[4];
    input = new ByteArrayInputStream(inSrc);
    output = new ByteArrayOutputStream();
    while (input.available()>0) {
      try {
        int length = input.read(tmp); // input을 읽어서 tmp에 담음, read 읽은 글자수를 반환
//        output.write(tmp);
        output.write(tmp,0,length);
        outSrc = output.toByteArray();
        System.out.println("tmp:" + Arrays.toString(tmp));
        System.out.println("outSrc:" + Arrays.toString(outSrc));
      } catch (IOException e) {
        throw new RuntimeException(e);
        // error가 발생해서 try/catch문 사용(드래그해서 surround 눌러서 try/catch 누름)
      }
    }
  }
}
