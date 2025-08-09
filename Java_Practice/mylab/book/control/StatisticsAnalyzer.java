package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> averagePrices = new HashMap<>();
        Map<String, Integer> totalPriceByType = new HashMap<>();
        Map<String, Integer> countByType = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceByType.put(type, totalPriceByType.getOrDefault(type, 0) + pub.getPrice());
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }

        for (String type : totalPriceByType.keySet()) {
            double average = (double) totalPriceByType.get(type) / countByType.get(type);
            averagePrices.put(type, average);
        }

        return averagePrices;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countByType = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        int totalCount = publications.length;
        for (String type : countByType.keySet()) {
            double percentage = ((double) countByType.get(type) / totalCount) * 100;
            distribution.put(type, percentage);
        }

        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return ((double) count / publications.length) * 100;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> averagePrices = calculateAveragePriceByType(publications);
        for (Map.Entry<String, Double> entry : averagePrices.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "원");
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + df.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
        System.out.println("=============================");
    }
}