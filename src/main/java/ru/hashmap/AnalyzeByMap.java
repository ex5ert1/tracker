package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0, totalSubjects = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                totalScore += s.score();
                totalSubjects++;
            }
        }
        return totalSubjects > 0 ? (double) totalScore / totalSubjects : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil p : pupils) {
            int sum = 0, count = p.subjects().size();
            for (Subject s : p.subjects()) sum += s.score();
            result.add(new Label(p.name(), count > 0 ? (double) sum / count : 0));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> sumMap = new LinkedHashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                sumMap.merge(s.name(), (double) s.score(), Double::sum);
                countMap.merge(s.name(), 1, Integer::sum);
            }
        }

        List<Label> result = new ArrayList<>();
        for (String subject : sumMap.keySet()) {
            result.add(new Label(subject, sumMap.get(subject) / countMap.get(subject)));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        for (Pupil p : pupils) {
            int sum = 0;
            for (Subject s : p.subjects()) sum += s.score();
            Label current = new Label(p.name(), sum);
            if (best == null || current.compareTo(best) > 0) best = current;
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new HashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                map.merge(s.name(), s.score(), Integer::sum);
            }
        }

        Label best = null;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Label current = new Label(e.getKey(), e.getValue());
            if (best == null || current.compareTo(best) > 0) best = current;
        }
        return best;
    }
}