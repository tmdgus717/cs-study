import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UnicodeEncodingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("인코딩할 값을 입력하세요: ");
        String inputValue = scanner.nextLine();

        // 유니코드 코드 포인트 출력
        System.out.println("유니코드 코드 포인트:");
        for (int i = 0; i < inputValue.length(); i++) { //U+C774
            int codePoint = inputValue.codePointAt(i);
            // 보조 평면 문자(이모지 등) 때문에 charAt(i)만 쓰면 잘릴 수 있음
            String ch = new String(Character.toChars(codePoint));

            System.out.printf("문자 '%s' : U+%04X%n", ch, codePoint);

            // 보조 평면 문자일 경우 코드 포인트가 2칸 차지하므로 보정
            if (Character.charCount(codePoint) == 2) {
                i++;
            }
        }

        // UTF-8 인코딩
        byte[] utf8Encoded = inputValue.getBytes(StandardCharsets.UTF_8);
        System.out.println("UTF-8 인코딩 결과: " + bytesToHex(utf8Encoded));

        // UTF-16 인코딩
        byte[] utf16Encoded = inputValue.getBytes(StandardCharsets.UTF_16);
        System.out.println("UTF-16 인코딩 결과: " + bytesToHex(utf16Encoded));
    }

    // 바이트 배열을 16진수 문자열로 변환
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
