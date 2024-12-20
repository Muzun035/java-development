package com.pluralsight;

public class GrassHopper {
    public static char getGrade(int s1, int s2, int s3) {
        double averageGrade = (s1 + s2 + s3)/3;

        if (averageGrade>=90){ return 'A';
        } else if (averageGrade>=80) {return 'B';
        }  else if (averageGrade >= 70) {
            return 'C';
        } else if (averageGrade>=60) {
            return 'D';
        }else return 'F';
    }
}