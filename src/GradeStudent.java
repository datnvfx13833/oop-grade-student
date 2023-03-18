import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Đây là chương trình Grade Student, cho phép người dùng nhập
 * vào thông tin về điểm số của sinh viên, sau đó hệ thống sẽ
 * tính toán và đưa ra Grade phù hợp cho sinh viên đó.
 */
public class GradeStudent {
    /**
     * Đây là phương thức begin() dùng để
     * in ra màn hình thông điệp chào mừng!
     */
    public static void begin(){
        System.out.println("This program reads exam/homework scores " +
                "and reports your overall course grade.");
        System.out.println();
    }

    /**
     * Đây là phương thức midTerm() dùng để lấy thông tin về
     * điểm thi và trọng số giữa kỳ của sinh viên, in và trả về
     * trọng số và điểm số giữa kỳ cuối cùng.
     * @return double[], phương thức trả về mảng kiểu double
     * với thành phần thứ nhất là trọng số giữa kỳ, thành phần
     * thứ hai là điểm số giữa kỳ cuối cùng.
     */
    public static double[] midTerm(){
        double[] midTermAns = new double[2];
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.0");

        System.out.println("Midterm: ");

        System.out.print("Weight (0-100) ? ");
        int weight = sc.nextInt();

        System.out.print("Score earned ? ");
        int score = sc.nextInt();

        System.out.print("Were scores shifted (1=yes, 2=no) ? ");
        int isShifted = sc.nextInt();

        int shiftAmount;
        if(isShifted == 1){
            System.out.print("Shift amount ? ");
            shiftAmount = sc.nextInt();
        } else {
            shiftAmount = 0;
        }

        int totalScore = score + shiftAmount;
        if(totalScore >= 100){
            totalScore = 100;
        }
        System.out.println("Total points = " +totalScore+" / 100" );

        double weightedScore = totalScore*weight/100.0;
        weightedScore = Double.parseDouble(df.format(weightedScore));
        System.out.println("Weighted score = "+ weightedScore + " / " + weight);

        System.out.println();

        midTermAns[0] = weight;
        midTermAns[1] = weightedScore;
        return midTermAns;
    }

    /**
     * Đây là phương thức finalTerm() dùng để lấy thông tin về
     * điểm thi và trọng số cuối kỳ của sinh viên, in và trả về
     * trọng số và điểm số cuối kỳ cuối cùng.
     * @return double[], phương thức trả về mảng kiểu double
     * với thành phần thứ nhất là trọng số cuối kỳ, thành phần
     * thứ hai là điểm số cuối kỳ cuối cùng.
     */
    public static double[] finalTerm(){
        double[] finalTermAns = new double[2];
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.0");

        System.out.println("Final: ");

        System.out.print("Weight (0-100) ? ");
        int weight = sc.nextInt();

        System.out.print("Score earned ? ");
        int score = sc.nextInt();

        System.out.print("Were scores shifted (1=yes, 2=no) ? ");
        int isShifted = sc.nextInt();

        int shiftAmount;
        if(isShifted == 1){
            System.out.print("Shift amount ? ");
            shiftAmount = sc.nextInt();
        } else {
            shiftAmount = 0;
        }

        int totalScore = score + shiftAmount;
        if(totalScore >= 100){
            totalScore = 100;
        }
        System.out.println("Total points = " +totalScore+" / 100" );

        double weightedScore = totalScore*weight/100.0;
        weightedScore = Double.parseDouble(df.format(weightedScore));
        System.out.println("Weighted score = "+ weightedScore + " / " + weight);

        System.out.println();

        finalTermAns[0] = weight;
        finalTermAns[1] = weightedScore;
        return finalTermAns;
    }

    /**
     * Đây là phương thức homework() dùng để lấy thông tin về
     * điểm các bài assignment, điểm chuyên cần và trọng số
     * homework của sinh viên, in và trả về trọng số và điểm số
     * homework cuối cùng.
     * @return double[], phương thức trả về mảng kiểu double
     * với thành phần thứ nhất là trọng số homework, thành phần
     * thứ hai là điểm số homework cuối cùng.
     */
    public static double[] homework(){
        double[] homeworkAns = new double[2];
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.0");

        System.out.println("Homework: ");
        System.out.print("Weight (0-100) ? ");
        int weight = sc.nextInt();

        System.out.print("Number of assignments ? ");
        int numberAssignment = sc.nextInt();

        int[][] arrayAssignment = new int[numberAssignment][2];

        for(int i = 0; i < numberAssignment; i++){
            System.out.print("Assignment " + (i+1) + " score and max? ");
            arrayAssignment[i][0] = sc.nextInt();
            arrayAssignment[i][1] = sc.nextInt();
        }

        System.out.print("How many sections did you attend? ");
        int numberSection = sc.nextInt();
        int sectionScore = numberSection*5;
        int sectionMax = 30;
        if(sectionScore > sectionMax){
            sectionScore = sectionMax;
        }
        System.out.println("Section points = " + sectionScore + " / " + sectionMax);

        int assignmentScore = 0;
        int assignmentScoreMax = 0;
        for(int i = 0; i < numberAssignment; i++){
            assignmentScore += arrayAssignment[i][0];
            assignmentScoreMax += arrayAssignment[i][1];
        }
        if(assignmentScore > 150){
            assignmentScore = 150;
        }

        int totalScore = sectionScore + assignmentScore;
        int totalMax = sectionMax + assignmentScoreMax;
        System.out.println("Total points = " + totalScore + " / " +totalMax);

        double weightedScore = totalScore*weight*1.0/totalMax;
        weightedScore = Double.parseDouble(df.format(weightedScore));
        System.out.println("Weighted score = " + weightedScore + " / " + weight);

        System.out.println();

        homeworkAns[0] = weight;
        homeworkAns[1] = weightedScore;

        return homeworkAns;
    }

    /**
     * Đây là phương thức report() dùng để tính toán và in
     * kết quả GPA cũng như thông báo nhận xét tương ứng.
     * @param midTerm , đây là tham số kiểu mảng double chứa thông tin
     *                trọng số và điểm số giữa kỳ cuối cùng.
     * @param finalTerm , đây là tham số kiểu mảng double chứa thông tin
     *                   trọng số và điểm số cuối kỳ cuối cùng.
     * @param homework , đây là tham số kiểu mảng double chứa thông tin
     *                    trọng số và điểm số homework cuối cùng.
     */
    public static void report(double[] midTerm, double[] finalTerm, double[] homework){
        int totalWeight = (int) (midTerm[0] + finalTerm[0] + homework[0]);
        double GPA;
        if(totalWeight != 100){
            System.out.println("Sum of your weights is not equal 100!!!");
        }else {
            double totalScore = midTerm[1] + finalTerm[1] + homework[1];
            totalScore = Math.ceil(totalScore*10.0)/10.0;
            if(totalScore == 100){
                GPA = 4.0;
            } else if (totalScore >= 85){
                GPA = 3.0;
            } else if (totalScore >= 75){
                GPA = 2.0;
            } else if (totalScore >= 60){
                GPA = 1.0;
            } else {
                GPA = 0.0;
            }
            System.out.println("Overall percentage = " + totalScore);
            System.out.println("Your grade will be at least: " + GPA);
            System.out.println("<< your custom grade message here >>");
        }
    }

    public static void main(String[] args){
        begin();
        double[] midTerm  = midTerm();
        double[] finalTerm = finalTerm();
        double[] homework = homework();
        report(midTerm,finalTerm,homework);
    }
}
