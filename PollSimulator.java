/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollsimulator;
import java.util.Random;
import java.util.Scanner;

public class PollSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] candNames = new String[5];
    candNames[0] = "Deep Goyal";
    candNames[1] = "Sneha Mohan";
    candNames[2] = "Praveen Shah";
    candNames[3] = "Akshay Singh";
    candNames[4] = "Somin Majumdar";
    Poll poll = new Poll( candNames );
    int nc = poll.getNumberOfCandidates();
    Random rand = new Random(55);
    Scanner vote = new Scanner(System.in);
    System.out.println("Enter a value between 1-5 tovote for respective candidates. \n1-Deep Goyal\n2-Sneha Mohan\n3-Praveen Shah\n4-Akshay Singh\n5-Somin Majumdar");
    for( int i = 1; i <=10; i++ ) {
        int x = vote.nextInt();
        poll.voteTo( x );
    } //Assume that candidates are identified as 1 through 5
    //Report the election result
    for(int i = 0;i <= poll.getNumberOfCandidates()-1; i++ ) {
        System.out.println(poll.getCandidateName(i)+ ": " + poll.votesCount(i));
    }

    System.out.println("Enter password to show results");
    int chances=3;
    while(chances>=1){
        String pass = vote.next();
        if(pass.equals(poll.getPaasword())){
            System.out.println("Winner: " + poll.getWinner());
            break;
        }
        else
            System.out.println("Total three chance only.");
        chances--;
    }
    System.out.print(poll.getNumberOfCandidates());

    }


}

class Poll {
    String[] candNames;
    int index = 0;
    int[] frequency = new int[5];

    public Poll(String[] candNames){
        this.candNames = candNames;
    }

    public int getNumberOfCandidates(){
        return candNames.length;
        }

    public void voteTo(int x){
        ++frequency[x-1];
    }

    public String getCandidateName(int in){
        return candNames[in];
    }

    public int votesCount(int in){
        return (frequency[in]);
    }

    public String getWinner(){
        int winner = 0;
            for(int i=0;i<frequency.length;i++){
                if(frequency[i]>winner){
                    winner = frequency[i];
                    index = i;
                }
            }
            System.out.println("With "+winner+" votes "+candNames[index]+" is the winner.");
            return candNames[index];

    }

    public String getPaasword(){
        return "Avdhesh";
    }

}

