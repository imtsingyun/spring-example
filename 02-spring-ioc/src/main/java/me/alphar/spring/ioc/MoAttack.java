package me.alphar.spring.ioc;

public class MoAttack implements ActorArrangable {

    private GeLi geLi;

    // 通过构造器注入
    public MoAttack(GeLi geli) {
        this.geLi = geli;
    }

    // 使用属性注入
    public void setGeLi(GeLi geLi) {
        this.geLi = geLi;
    }

    // 使用接口注入
    @Override
    public void injectGeLi(GeLi geLi) {
        this.geLi = geLi;
    }

    public void cityGateAsk() {
        geLi.responseAsk("墨者革离");
    }

}
