import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi:");
        String str = sc.nextLine();

        String[] words = str.toLowerCase().split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        // Đếm số lần xuất hiện
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Sắp xếp A-Z
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        System.out.println("Tần suất các từ (A-Z):");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Tìm từ xuất hiện nhiều nhất
        String maxWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        System.out.println("Từ xuất hiện nhiều nhất: " + maxWord + " (" + maxCount + " lần)");
    }
}