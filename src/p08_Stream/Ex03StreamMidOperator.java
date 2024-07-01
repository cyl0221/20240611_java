package p08_Stream;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Ex03StreamMidOperator {
  public static void main(String[] args) {
    String dir = "C:\\workspace\\spaceJava\\20240611_java";
    try {
      Stream<Path> fileListStream = Files.list(Paths.get(dir));
      fileListStream
          // n개가 들어오면 n개의 각각에 대하여 처리할것을 정의
          // Stream<Path> 원소의 타입이 <Path>다 라는 의미, path는 경로에대한 의미
          .map(new Function<Path, File>() {
            //ileListStream의 각 Path 객체를 File 객체로 변환한 후, 이 새로운 File 스트림을 반환합니다.
            // 이후 forEach 메서드를 사용하여 각 File 객체의 이름을 출력하고 있습니다.
            @Override
            public File apply(Path path) { //function의 추상method apply로 재정의?!
              return path.toFile();
            } // File 은 File도 담을 수 있고, 폴더(directory)도 나타낼수있다.
          })
          /*.peek(new Consumer<Object>() {
        @Override
        public void accept(Object o) { //consumer -> accept
          System.out.println(o.toString()+",");

        }
      });*/ // n개가 들어와서 필터링을 거쳐 m개를 리턴함
          .filter(new Predicate<Object>() { //new를 써서 익명개체를 만듬.
            @Override
            public boolean test(Object o) {
              File file = (File) o;
              return file.isFile(); // 파일만 출력
            }
            // 아래처럼도 사용가능
            /*public boolean test(File file) {
              return file.isFile();
            }*/
          }) //m개가 들어와서 m개를 리턴
          .map(new Function<File, String>() {
            @Override
            public String apply(File file) { // function -> apply  // 입력
              return file.toString(); //문자열로 출력
            }
          })
          .map(new Function<String, String>() {
            @Override
            public String apply(String s) {
              return s.toUpperCase(); // 문자열을 대문자로 변경
            }
          })
          .distinct() // 중복을 제거해준다.
          // 각각의 원소에 대해서 적용 입력은 있지만, 출력은 없다.
          .forEach(new Consumer<String>() { // Consumer 소비한다. 따로 return 을 안하고 소비만 하고 끝난다.
            @Override
            public void accept(String s) {
              System.out.println(s);
            }
          });
      ;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
