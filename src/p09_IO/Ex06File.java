package p09_IO;

import java.io.File;
import java.io.IOException;

public class Ex06File {
  public static void main(String[] args) {
    //1) File 객체는 폴더를 다룰 수 있다.
    File file = new File(".");
    if (file.exists() && file.isDirectory()) {
      String[] fileList = file.list();
      for (int i = 0; i < fileList.length; i++) {
        System.out.println(fileList[i]); //배열의 요소(element),fileList만 입력한다면 배열만 찍는것
      }
    } else {
      System.out.println("이것은 경로가 잘못됐습니다.");
    }
    // 2) File 객체는 파일을 다룰 수 있다.
    file = new File("test.txt");
    if (file.exists()) { //절대경로 루트로 부터, / 상대경로: 현재 내가 있는 폴더의 위치
      try {
        System.out.println(file.getName()); //example.txt 를 반환
        System.out.println(file.getPath()); // 상대경로
        System.out.println(file.getAbsolutePath()); //절대경로 AbsolutePath
        System.out.println(file.getCanonicalPath()); // 정규화된 절대 경로를 반환하며, 파일 시스템의 실제 경로를 반환합니다.
        System.out.println(file.getParent()); // 부모의 경로
        System.out.println(file.canExecute()); //파일 실행가능 여부 확인
        System.out.println(file.canRead()); // 파일 읽을수 있는지 여부 확인
        System.out.println(file.canWrite()); // 파일을 쓰기 가능여부 확인
        System.out.println(file.isFile()); //File 객체 file이 실제로 파일인지 여부를 확인하는 메서드입니다. 즉, 해당 경로가 파일을 가리키는지를 판단합니다.
        System.out.println(file.length()); //파일의 크기를 바이트 단위로 반환합니다. 즉, 해당 파일의 크기를 정수로 반환합니다.
        System.out.println(file.toString().substring(file.toString().lastIndexOf(".")+1)); //확장자를 추출하는 과정입니다.
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    // 3) File 객체는 Drive의 정보를 알 수 있다.
    String drive;
    double totalSpace, usedSapce,  usebleSpace, freeSpace;
    File[] roots = File.listRoots();
    for (File f : roots) {
      drive = f.getAbsolutePath();
      totalSpace = f.getTotalSpace() / Math.pow(1024,3);
      usebleSpace = f.getUsableSpace()/ Math.pow(1024,3);
      freeSpace = f.getFreeSpace() / Math.pow(1024,3);
      usedSapce = totalSpace - usebleSpace;
      System.out.println("Dirve: " + drive);
      System.out.printf("total Space: %5.2f GB %n" , totalSpace);
      System.out.printf("useble Space: %5.2f GB %n" ,usebleSpace);
      System.out.printf("free Space: %5.2f GB %n" , freeSpace);
      System.out.printf("used Space: %5.2f GB %n"  , usedSapce);

    }
  }
}
