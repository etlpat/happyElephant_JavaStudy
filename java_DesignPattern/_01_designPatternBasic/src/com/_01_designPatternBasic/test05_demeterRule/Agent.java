package com._01_designPatternBasic.test05_demeterRule;

import java.util.HashSet;

// 经纪人
public class Agent {
    private Star star;// 用于维护明星
    private HashSet<Fans> fansHashSet;// 用于维护粉丝们
    private HashSet<Company> companyHashSet;// 用于维护公司们

    public Agent(Star star) {
        this.star = star;
        fansHashSet = new HashSet<Fans>();
        companyHashSet = new HashSet<Company>();
    }


    // 处理明星和粉丝
    public void dealStarsAndFans() {
        for (Fans fans : fansHashSet) {
            System.out.println(star.getName() + "与Fans" + fans.getName() + "会面");
        }
    }

    // 处理公司和公司
    public void dealStarsAndCompany() {
        for (Company company : companyHashSet) {
            System.out.println(star.getName() + "与Company" + company.getName() + "签订业务");
        }
    }


    public void addFans(Fans fans) {
        fansHashSet.add(fans);
    }

    public void removeFans(Fans fans) {
        fansHashSet.remove(fans);
    }

    public void addCompany(Company company) {
        companyHashSet.add(company);
    }

    public void removeCompany(Company company) {
        companyHashSet.remove(company);
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }
}
