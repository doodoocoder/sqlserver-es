package com.vzhen.demo.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Objects;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/29
 * @description TODO
 * @return
 */
@Document(indexName = "basic_info", type = "patient", shards = 1, replicas = 0)
@Table(name = "Tb_Ba_Jbxx")
public class TbBaJbxx {
    @Id
    private String index;//es的索引，不能与表的id用一个
    @Field
    @JSONField(serialize=false)
    private long extractTime;
    //不用写入es,不转化成Json字符串
    @JSONField(serialize=false)
    @JsonIgnore//不写入es
    private String state;
    @Field(fielddata = true)
    private String xseXb;
    @Field
    private String xseTz;
    @Field
    private String sfzh;
    @Field
    private String hzlxdh;
    @Field
    private String gzdzdm;
    @Field
    private String gzdw;
    @Field
    private String gzdwdh;
    @Field
    private String gzdwyb;
    @Field
    private String zylbdm;
    @Field
    private String xzzxzqhdm;
    @Field
    private String jzd;
    @Field
    private String xzzdh;
    @Field
    private String xzzyb;
    @Field
    private String hkdzdm;
    @Field
    private String hkdzmc;
    @Field
    private String hkdh;
    @Field
    private String hkyb;
    @Field
    private String lxrxm;
    @Field
    private String lxrgx;
    @Field
    private String lxrdzdm;
    @Field
    private String lxrdz;
    @Field
    private String lxrdh;
    @Field
    private String rysj;
    @Field
    private String ryksbm;
    @Field
    private String ryksmc;
    @Field
    private String rybq;
    @Field
    private String zkksbm1;
    @Field
    private String zkksbm2;
    @Field
    private String zkksbm3;
    @Field
    private String cysj;
    @Field
    private String cyksbm;
    @Field
    private String cybq;
    @Field
    private String sjzyts;
    @Field
    private String zyzdqzrq;
    @Field
    private String zyqjsfgzBwhbz;
    @Field
    private String bazxbz;
    @Field
    private String dwfzr;
    @Field
    private String tjfzr;
    @Field
    private String tbr;
    @Field
    private String lxdh;
    @Field
    private String sj;
    @Field
    private String bcrq;
    @Field
    private String bz;
    @Field
    private String mj;
    @Field
    private String xgbz;
    @Field
    private String csdmc;
    @Field
    private String csddm;
    @Field
    private String jgmc;
    @Field
    private String hgdn;
    @Field
    private String gjmc;
    @Field
    private String gjdm;
    @Field
    private String mzdm;
    @Field
    private String hyzkdm;
    @Field
    private String xserytz;
    @Field
    private String xsecstz;
    @Field
    private String ryqkdm;
    @Field
    private String hzln;
    @Field
    private String csrq;
    @Field
    private String ch;
    @Field
    private String xb;
    @Field
    private String xm;
    @Field
    private String bah;
    @Field
    private String zycs;
    @Field
    private String ylfffs;
    @Field
    private String jkkh;
    @Field
    private String bxlx;
    @Field
    private String zllb;
    @Field
    private String qtjgzr;
    @Field
    private String rylx;
    @Field
    private String yxqz;
    @Field
    private String ndjd;
    @Field
    private String sjly;
    @Field
    private String grbsh;
    @Field
    private String grbslx;
    @Field
    private String jzlsh;
    @Field
    @AssignID
    private String bajbxxid;
    @Field
    private String yljgdm;

    public String getXseXb() {
        return xseXb;
    }

    public void setXseXb(String xseXb) {
        this.xseXb = xseXb;
    }


    public String getXseTz() {
        return xseTz;
    }

    public void setXseTz(String xseTz) {
        this.xseTz = xseTz;
    }


    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }


    public String getHzlxdh() {
        return hzlxdh;
    }

    public void setHzlxdh(String hzlxdh) {
        this.hzlxdh = hzlxdh;
    }


    public String getGzdzdm() {
        return gzdzdm;
    }

    public void setGzdzdm(String gzdzdm) {
        this.gzdzdm = gzdzdm;
    }


    public String getGzdw() {
        return gzdw;
    }

    public void setGzdw(String gzdw) {
        this.gzdw = gzdw;
    }


    public String getGzdwdh() {
        return gzdwdh;
    }

    public void setGzdwdh(String gzdwdh) {
        this.gzdwdh = gzdwdh;
    }


    public String getGzdwyb() {
        return gzdwyb;
    }

    public void setGzdwyb(String gzdwyb) {
        this.gzdwyb = gzdwyb;
    }


    public String getZylbdm() {
        return zylbdm;
    }

    public void setZylbdm(String zylbdm) {
        this.zylbdm = zylbdm;
    }


    public String getXzzxzqhdm() {
        return xzzxzqhdm;
    }

    public void setXzzxzqhdM(String xzzxzqhdm) {
        this.xzzxzqhdm = xzzxzqhdm;
    }


    public String getJzd() {
        return jzd;
    }

    public void setJzd(String jzd) {
        this.jzd = jzd;
    }


    public String getXzzdh() {
        return xzzdh;
    }

    public void setXzzdh(String xzzdh) {
        this.xzzdh = xzzdh;
    }

    public String getXzzyb() {
        return xzzyb;
    }

    public void setXzzyb(String xzzyb) {
        this.xzzyb = xzzyb;
    }


    public String getHkdzdm() {
        return hkdzdm;
    }

    public void setHkdzdm(String hkdzdm) {
        this.hkdzdm = hkdzdm;
    }


    public String getHkdzmc() {
        return hkdzmc;
    }

    public void setHkdzmc(String hkdzmc) {
        this.hkdzmc = hkdzmc;
    }


    public String getHkdh() {
        return hkdh;
    }

    public void setHkdh(String hkdh) {
        this.hkdh = hkdh;
    }

    public String getHkyb() {
        return hkyb;
    }

    public void setHkyb(String hkyb) {
        this.hkyb = hkyb;
    }


    public String getLxrxm() {
        return lxrxm;
    }

    public void setLxrxm(String lxrxm) {
        this.lxrxm = lxrxm;
    }


    public String getLxrgx() {
        return lxrgx;
    }

    public void setLxrgx(String lxrgx) {
        this.lxrgx = lxrgx;
    }


    public String getLxrdzdm() {
        return lxrdzdm;
    }

    public void setLxrdzdm(String lxrdzdm) {
        this.lxrdzdm = lxrdzdm;
    }

    public String getLxrdz() {
        return lxrdz;
    }

    public void setLxrdz(String lxrdz) {
        this.lxrdz = lxrdz;
    }


    public String getLxrdh() {
        return lxrdh;
    }

    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh;
    }


    public String getRysj() {
        return rysj;
    }

    public void setRysj(String rysj) {
        this.rysj = rysj;
    }


    public String getRyksbm() {
        return ryksbm;
    }

    public void setRyksbm(String ryksbm) {
        this.ryksbm = ryksbm;
    }


    public String getRyksmc() {
        return ryksmc;
    }

    public void setRyksmc(String ryksmc) {
        this.ryksmc = ryksmc;
    }


    public String getRybq() {
        return rybq;
    }

    public void setRybq(String rybq) {
        this.rybq = rybq;
    }


    public String getZkksbm1() {
        return zkksbm1;
    }

    public void setZkksbm1(String zkksbm1) {
        this.zkksbm1 = zkksbm1;
    }


    public String getZkksbm2() {
        return zkksbm2;
    }

    public void setZkksbm2(String zkksbm2) {
        this.zkksbm2 = zkksbm2;
    }


    public String getZkksbm3() {
        return zkksbm3;
    }

    public void setZkksbm3(String zkksbm3) {
        this.zkksbm3 = zkksbm3;
    }


    public String getCysj() {
        return cysj;
    }

    public void setCysj(String cysj) {
        this.cysj = cysj;
    }


    public String getCyksbm() {
        return cyksbm;
    }

    public void setCyksbm(String cyksbm) {
        this.cyksbm = cyksbm;
    }


    public String getCybq() {
        return cybq;
    }

    public void setCybq(String cybq) {
        this.cybq = cybq;
    }

    public String getSjzyts() {
        return sjzyts;
    }

    public void setSjzyts(String sjzyts) {
        this.sjzyts = sjzyts;
    }


    public String getZyzdqzrq() {
        return zyzdqzrq;
    }

    public void setZyzdqzrq(String zyzdqzrq) {
        this.zyzdqzrq = zyzdqzrq;
    }


    public String getZyqjsfgzBwhbz() {
        return zyqjsfgzBwhbz;
    }

    public void setZyqjsfgzBwhbz(String zyqjsfgzBwhbz) {
        this.zyqjsfgzBwhbz = zyqjsfgzBwhbz;
    }


    public String getBazxbz() {
        return bazxbz;
    }

    public void setBazxbz(String bazxbz) {
        this.bazxbz = bazxbz;
    }


    public String getDwfzr() {
        return dwfzr;
    }

    public void setDwfzr(String dwfzr) {
        this.dwfzr = dwfzr;
    }


    public String getTjfzr() {
        return tjfzr;
    }

    public void setTjfzr(String tjfzr) {
        this.tjfzr = tjfzr;
    }


    public String getTbr() {
        return tbr;
    }

    public void setTbr(String tbr) {
        this.tbr = tbr;
    }


    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }


    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getBcrq() {
        return bcrq;
    }

    public void setBcrq(String bcrq) {
        this.bcrq = bcrq;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }


    public String getMj() {
        return mj;
    }

    public void setMj(String mj) {
        this.mj = mj;
    }


    public String getXgbz() {
        return xgbz;
    }

    public void setXgbz(String xgbz) {
        this.xgbz = xgbz;
    }


    public String getCsdmc() {
        return csdmc;
    }

    public void setCsdmc(String csdmc) {
        this.csdmc = csdmc;
    }


    public String getCsddm() {
        return csddm;
    }

    public void setCsddm(String csddm) {
        this.csddm = csddm;
    }


    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }


    public String getHgdn() {
        return hgdn;
    }

    public void setHgdn(String hgdn) {
        this.hgdn = hgdn;
    }


    public String getGjmc() {
        return gjmc;
    }

    public void setGjmc(String gjmc) {
        this.gjmc = gjmc;
    }

    public String getGjdm() {
        return gjdm;
    }

    public void setGjdm(String gjdm) {
        this.gjdm = gjdm;
    }


    public String getMzdm() {
        return mzdm;
    }

    public void setMzdm(String mzdm) {
        this.mzdm = mzdm;
    }


    public String getHyzkdm() {
        return hyzkdm;
    }

    public void setHyzkdm(String hyzkdm) {
        this.hyzkdm = hyzkdm;
    }


    public String getXserytz() {
        return xserytz;
    }

    public void setXserytz(String xserytz) {
        this.xserytz = xserytz;
    }


    public String getXsecstz() {
        return xsecstz;
    }

    public void setXsecstz(String xsecstz) {
        this.xsecstz = xsecstz;
    }


    public String getRyqkdm() {
        return ryqkdm;
    }

    public void setRyqkdm(String ryqkdm) {
        this.ryqkdm = ryqkdm;
    }


    public String getHzln() {
        return hzln;
    }

    public void setHzln(String hzln) {
        this.hzln = hzln;
    }


    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }


    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }


    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }


    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }


    public String getBah() {
        return bah;
    }

    public void setBah(String bah) {
        this.bah = bah;
    }

    public String getZycs() {
        return zycs;
    }

    public void setZycs(String zycs) {
        this.zycs = zycs;
    }


    public String getYlfffs() {
        return ylfffs;
    }

    public void setYlfffs(String ylfffs) {
        this.ylfffs = ylfffs;
    }


    public String getJkkh() {
        return jkkh;
    }

    public void setJkkh(String jkkh) {
        this.jkkh = jkkh;
    }

    public String getBxlx() {
        return bxlx;
    }

    public void setBxlx(String bxlx) {
        this.bxlx = bxlx;
    }


    public String getZllb() {
        return zllb;
    }

    public void setZllb(String zllb) {
        this.zllb = zllb;
    }


    public String getQtjgzr() {
        return qtjgzr;
    }

    public void setQtjgzr(String qtjgzr) {
        this.qtjgzr = qtjgzr;
    }


    public String getRylx() {
        return rylx;
    }

    public void setRylx(String rylx) {
        this.rylx = rylx;
    }


    public String getYxqz() {
        return yxqz;
    }

    public void setYxqz(String yxqz) {
        this.yxqz = yxqz;
    }


    public String getNdjd() {
        return ndjd;
    }

    public void setNdjd(String ndjd) {
        this.ndjd = ndjd;
    }


    public String getSjly() {
        return sjly;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly;
    }


    public String getGrbsh() {
        return grbsh;
    }

    public void setGrbsh(String grbsh) {
        this.grbsh = grbsh;
    }


    public String getGrbslx() {
        return grbslx;
    }

    public void setGrbslx(String grbslx) {
        this.grbslx = grbslx;
    }


    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }


    public String getBajbxxid() {
        return bajbxxid;
    }

    public void setBajbxxid(String bajbxxid) {
        this.bajbxxid = bajbxxid;
    }


    public String getYljgdm() {
        return yljgdm;
    }

    public void setYljgdm(String yljgdm) {
        this.yljgdm = yljgdm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbBaJbxx tbBaJbxx = (TbBaJbxx) o;
        return Objects.equals(xseXb, tbBaJbxx.xseXb) &&
                Objects.equals(xseTz, tbBaJbxx.xseTz) &&
                Objects.equals(sfzh, tbBaJbxx.sfzh) &&
                Objects.equals(hzlxdh, tbBaJbxx.hzlxdh) &&
                Objects.equals(gzdzdm, tbBaJbxx.gzdzdm) &&
                Objects.equals(gzdw, tbBaJbxx.gzdw) &&
                Objects.equals(gzdwdh, tbBaJbxx.gzdwdh) &&
                Objects.equals(gzdwyb, tbBaJbxx.gzdwyb) &&
                Objects.equals(zylbdm, tbBaJbxx.zylbdm) &&
                Objects.equals(xzzxzqhdm, tbBaJbxx.xzzxzqhdm) &&
                Objects.equals(jzd, tbBaJbxx.jzd) &&
                Objects.equals(xzzdh, tbBaJbxx.xzzdh) &&
                Objects.equals(xzzyb, tbBaJbxx.xzzyb) &&
                Objects.equals(hkdzdm, tbBaJbxx.hkdzdm) &&
                Objects.equals(hkdzmc, tbBaJbxx.hkdzmc) &&
                Objects.equals(hkdh, tbBaJbxx.hkdh) &&
                Objects.equals(hkyb, tbBaJbxx.hkyb) &&
                Objects.equals(lxrxm, tbBaJbxx.lxrxm) &&
                Objects.equals(lxrgx, tbBaJbxx.lxrgx) &&
                Objects.equals(lxrdzdm, tbBaJbxx.lxrdzdm) &&
                Objects.equals(lxrdz, tbBaJbxx.lxrdz) &&
                Objects.equals(lxrdh, tbBaJbxx.lxrdh) &&
                Objects.equals(rysj, tbBaJbxx.rysj) &&
                Objects.equals(ryksbm, tbBaJbxx.ryksbm) &&
                Objects.equals(ryksmc, tbBaJbxx.ryksmc) &&
                Objects.equals(rybq, tbBaJbxx.rybq) &&
                Objects.equals(zkksbm1, tbBaJbxx.zkksbm1) &&
                Objects.equals(zkksbm2, tbBaJbxx.zkksbm2) &&
                Objects.equals(zkksbm3, tbBaJbxx.zkksbm3) &&
                Objects.equals(cysj, tbBaJbxx.cysj) &&
                Objects.equals(cyksbm, tbBaJbxx.cyksbm) &&
                Objects.equals(cybq, tbBaJbxx.cybq) &&
                Objects.equals(sjzyts, tbBaJbxx.sjzyts) &&
                Objects.equals(zyzdqzrq, tbBaJbxx.zyzdqzrq) &&
                Objects.equals(zyqjsfgzBwhbz, tbBaJbxx.zyqjsfgzBwhbz) &&
                Objects.equals(bazxbz, tbBaJbxx.bazxbz) &&
                Objects.equals(dwfzr, tbBaJbxx.dwfzr) &&
                Objects.equals(tjfzr, tbBaJbxx.tjfzr) &&
                Objects.equals(tbr, tbBaJbxx.tbr) &&
                Objects.equals(lxdh, tbBaJbxx.lxdh) &&
                Objects.equals(sj, tbBaJbxx.sj) &&
                Objects.equals(bcrq, tbBaJbxx.bcrq) &&
                Objects.equals(bz, tbBaJbxx.bz) &&
                Objects.equals(mj, tbBaJbxx.mj) &&
                Objects.equals(xgbz, tbBaJbxx.xgbz) &&
                Objects.equals(csdmc, tbBaJbxx.csdmc) &&
                Objects.equals(csddm, tbBaJbxx.csddm) &&
                Objects.equals(jgmc, tbBaJbxx.jgmc) &&
                Objects.equals(hgdn, tbBaJbxx.hgdn) &&
                Objects.equals(gjmc, tbBaJbxx.gjmc) &&
                Objects.equals(gjdm, tbBaJbxx.gjdm) &&
                Objects.equals(mzdm, tbBaJbxx.mzdm) &&
                Objects.equals(hyzkdm, tbBaJbxx.hyzkdm) &&
                Objects.equals(xserytz, tbBaJbxx.xserytz) &&
                Objects.equals(xsecstz, tbBaJbxx.xsecstz) &&
                Objects.equals(ryqkdm, tbBaJbxx.ryqkdm) &&
                Objects.equals(hzln, tbBaJbxx.hzln) &&
                Objects.equals(csrq, tbBaJbxx.csrq) &&
                Objects.equals(ch, tbBaJbxx.ch) &&
                Objects.equals(xb, tbBaJbxx.xb) &&
                Objects.equals(xm, tbBaJbxx.xm) &&
                Objects.equals(bah, tbBaJbxx.bah) &&
                Objects.equals(zycs, tbBaJbxx.zycs) &&
                Objects.equals(ylfffs, tbBaJbxx.ylfffs) &&
                Objects.equals(jkkh, tbBaJbxx.jkkh) &&
                Objects.equals(bxlx, tbBaJbxx.bxlx) &&
                Objects.equals(zllb, tbBaJbxx.zllb) &&
                Objects.equals(qtjgzr, tbBaJbxx.qtjgzr) &&
                Objects.equals(rylx, tbBaJbxx.rylx) &&
                Objects.equals(yxqz, tbBaJbxx.yxqz) &&
                Objects.equals(ndjd, tbBaJbxx.ndjd) &&
                Objects.equals(sjly, tbBaJbxx.sjly) &&
                Objects.equals(grbsh, tbBaJbxx.grbsh) &&
                Objects.equals(grbslx, tbBaJbxx.grbslx) &&
                Objects.equals(jzlsh, tbBaJbxx.jzlsh) &&
                Objects.equals(bajbxxid, tbBaJbxx.bajbxxid) &&
                Objects.equals(yljgdm, tbBaJbxx.yljgdm);
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public long getExtractTime() {
        return extractTime;
    }

    public void setExtractTime(long extractTime) {
        this.extractTime = extractTime;
    }

    @Override
    public int hashCode() {

        return Objects.hash(xseXb, xseTz, sfzh, hzlxdh, gzdzdm, gzdw, gzdwdh, gzdwyb, zylbdm, xzzxzqhdm, jzd, xzzdh, xzzyb, hkdzdm, hkdzmc, hkdh, hkyb, lxrxm, lxrgx, lxrdzdm, lxrdz, lxrdh, rysj, ryksbm, ryksmc, rybq, zkksbm1, zkksbm2, zkksbm3, cysj, cyksbm, cybq, sjzyts, zyzdqzrq, zyqjsfgzBwhbz, bazxbz, dwfzr, tjfzr, tbr, lxdh, sj, bcrq, bz, mj, xgbz, csdmc, csddm, jgmc, hgdn, gjmc, gjdm, mzdm, hyzkdm, xserytz, xsecstz, ryqkdm, hzln, csrq, ch, xb, xm, bah, zycs, ylfffs, jkkh, bxlx, zllb, qtjgzr, rylx, yxqz, ndjd, sjly, grbsh, grbslx, jzlsh, bajbxxid, yljgdm);
    }
}
