
public class Poll {
    String Cand[];
    int votes[];
    public Poll(String []Cand){
        this.Cand=Cand;
        votes=new int[Cand.length];

    }
    public int getNumberOfCandidates(){
        return Cand.length;
    }
    public void voteTo(int x){
        votes[x-1]++;

    }
    public String getCandidateName(int x){
        return Cand[x-1];
    }
    public int votesCount(int x){
        return votes[x-1];
    }
    public String getWinner(){
        int max=0,index=0;
        for(int i=0;i<votes.length;i++){
            if(max<votes[i]){
                max=votes[i];
                index=i;
            }

        }
        return  Cand[index];
    }


}
