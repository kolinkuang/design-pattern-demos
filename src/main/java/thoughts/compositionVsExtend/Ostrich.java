package thoughts.compositionVsExtend;

public class Ostrich implements Tweetable, EggLayable {

    private final TweetAbility tweetAbility = new TweetAbility(); //组合
    private final EggLayAbility eggLayAbility = new EggLayAbility(); //组合

    @Override
    public void layEgg() {
        eggLayAbility.layEgg(); // 委托
    }

    @Override
    public void tweet() {
        tweetAbility.tweet(); // 委托
    }

}
