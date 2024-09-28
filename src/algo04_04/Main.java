package algo04_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 04-04 모든 아나그램 찾기
 *
 * HashMap과 sliding window를 모두 사용해서 풀어보기
 * */

public class Main {
    public static int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> hmA = new HashMap<>();
        HashMap<Character, Integer> hmB = new HashMap<>();
        int lt = 0;

        for (char c : b.toCharArray()) {
            hmB.put(c, hmB.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < b.length() - 1; i++) {
            hmA.put(a.charAt(i), hmA.getOrDefault(a.charAt(i), 0) + 1);
        }

        for (int rt = b.length() - 1; rt < a.length(); rt++) {
            hmA.put(a.charAt(rt), hmA.getOrDefault(a.charAt(rt), 0) + 1);
            if (hmA.equals(hmB)) {
                answer++;
            }
            hmA.put(a.charAt(lt), hmA.get(a.charAt(lt)) - 1);
            if (hmA.get(a.charAt(lt)) == 0) {
                hmA.remove(a.charAt(lt));
            }
            lt++;
        }

        return answer;


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }
}
