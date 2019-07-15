package lyb.practice.creational;

/**
 * 项目名称：pattern
 * 功能说明: :标准产品
 * 创建日期：2019/7/11
 * 创建人：LYB
 */
public class StandardProduct implements Product{
    public String name ;
    public String name1 ;
    public StandardProduct() {
    }

    @Override
    public void show() {
        System.out.println("这是一个"+name);
    }

    public StandardProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void getF(){}
    protected void getFa(){}
    int getFa2(){
        return 1;
    }

}
