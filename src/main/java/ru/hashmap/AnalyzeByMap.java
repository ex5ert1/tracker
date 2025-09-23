package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalSubjects > 0 ? (double) totalScore / totalSubjects : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            int subjectCount = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double average = subjectCount > 0 ? (double) totalScore / subjectCount : 0;
            result.add(new Label(pupil.name(), average));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, List<Integer>> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = subject.score();
                if (!subjectScores.containsKey(name)) {
                    subjectScores.put(name, new ArrayList<>());
                }
                subjectScores.get(name).add(score);
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            List<Integer> scores = entry.getValue();
            int total = 0;
            for (int score : scores) {
                total += score;
            }
            double average = scores.size() > 0 ? (double) total / scores.size() : 0;
            result.add(new Label(subjectName, average));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            Label current = new Label(pupil.name(), totalScore);
            if (best == null || current.compareTo(best) > 0) {
                best = current;
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectTotals = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = subject.score();
                if (subjectTotals.containsKey(name)) {
                    subjectTotals.put(name, subjectTotals.get(name) + score);
                } else {
                    subjectTotals.put(name, score);
                }
            }
        }

        Label best = null;
        for (Map.Entry<String, Integer> entry : subjectTotals.entrySet()) {
            Label current = new Label(entry.getKey(), entry.getValue());

            if (best == null || current.compareTo(best) > 0) {
                best = current;
            }
        }
        return best;
    }
}