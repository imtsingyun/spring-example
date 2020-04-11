package me.alphar.spring.ioc;

public class Director {

    public void direct() {
        GeLi geLi = new LiuDeHua();

        // 使用构造器注入
        MoAttack moAttack = new MoAttack(geLi);
        // 便用属性注入
        moAttack.setGeLi(geLi);
        // 使用接口注入
        moAttack.injectGeLi(geLi);

        moAttack.cityGateAsk();
    }
}
