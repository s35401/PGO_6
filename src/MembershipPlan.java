public abstract class MembershipPlan implements BIllable {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }
    public abstract String getPlanType();
    @Override
    public abstract double calculateMonthlyNetPrice();

    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyGrossPrice() * 1.23;
    }
    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }
    public final void printSummary() {
        System.out.println("Plan: " + getPlanType() + " [" + planCode + "]");
        System.out.println("Klient: " + clientName);
        System.out.println("Cena netto: " + calculateMonthlyNetPrice() + " zł");
        System.out.println("Cena brutto: " + calculateMonthlyGrossPrice() + " zł");
        System.out.println("Cena całkowita netto: " + calculateTotalNetPrice() + " zł");
    }
    @Override
    public String toString() {
        return "Kod: " + planCode + ", Klient: " + clientName + ", Miesięcy: " + months +
                ", Auto-odnawianie: " + (autoRenew ? "Tak" : "Nie");
    }
    protected double getBaseMonthlyFee() { return baseMonthlyFee; }
    protected boolean isAutoRenew() { return autoRenew; }
    protected int getMonths() { return months; }

}
