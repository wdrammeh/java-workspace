package dps;

public class Records {

    public static void addMarData(Month month) {
        month.setDays(
            Day.on(month, 1).setDefaultInflow(455),
            Day.on(month, 2).setDefaultInflow(460),
            Day.on(month, 3).setDefaultInflow(550).setDefaultOutflow(500),
            Day.on(month, 4).setDefaultInflow(560),
            Day.on(month, 5).setDefaultInflow(425),
            Day.on(month, 6).setDefaultInflow(510),
            Day.on(month, 7).setDefaultInflow(405),
            Day.on(month, 8).setDefaultInflow(405),
            Day.on(month, 9).setDefaultInflow(420), // 360?
            Day.on(month, 10).setDefaultInflow(535),
            Day.on(month, 11).setDefaultInflow(420),
            Day.on(month, 12).setDefaultInflow(445).setDefaultOutflow(500),
            Day.on(month, 13).setDefaultInflow(425),
            Day.on(month, 14).setDefaultInflow(710),
            Day.on(month, 15).setDefaultInflow(405),
            Day.on(month, 16).setDefaultInflow(305),
            Day.on(month, 17).setDefaultInflow(315),
            Day.on(month, 18).setDefaultInflow(480),
            Day.on(month, 19).setDefaultInflow(905),
            Day.on(month, 20).setDefaultInflow(265),
            Day.on(month, 21).setDefaultInflow(730).setDefaultOutflow(500),
            Day.on(month, 22).setDefaultInflow(305),
            Day.on(month, 23).setDefaultInflow(425),
            Day.on(month, 24).setDefaultInflow(455),
            Day.on(month, 25).setDefaultInflow(510),
            Day.on(month, 26).setDefaultInflow(610),
            Day.on(month, 27).setDefaultInflow(450),
            Day.on(month, 28).setDefaultInflow(415),
            Day.on(month, 29).setDefaultInflow(315),
            Day.on(month, 30).setDefaultInflow(360),
            Day.on(month, 31).setDefaultInflow(0)
        );
    }

    public static void addFebData(Month month) {
        month.setDays(
            Day.on(month, 1).setDefaultInflow(595).setDefaultOutflow(60),
            Day.on(month, 2).setDefaultInflow(540).setDefaultOutflow(300),
            Day.on(month, 3).setDefaultInflow(460),
            Day.on(month, 4).setDefaultInflow(510),
            Day.on(month, 5).setDefaultInflow(535),
            Day.on(month, 6).setDefaultInflow(430),
            Day.on(month, 7).setDefaultInflow(535),
            Day.on(month, 8).setDefaultInflow(590).setDefaultOutflow(300),
            Day.on(month, 9).setDefaultInflow(400),
            Day.on(month, 10).setDefaultInflow(225),
            Day.on(month, 11).setDefaultInflow(240),
            Day.on(month, 12).setDefaultInflow(330),
            Day.on(month, 13).setDefaultInflow(505),
            Day.on(month, 14).setDefaultInflow(445).setDefaultOutflow(300),
            Day.on(month, 15).setDefaultInflow(560),
            Day.on(month, 16).setDefaultInflow(430),
            Day.on(month, 17).setDefaultInflow(310),
            Day.on(month, 18).setDefaultInflow(330),
            Day.on(month, 19).setDefaultInflow(530),
            Day.on(month, 20).setDefaultInflow(310).setDefaultOutflow(300),
            Day.on(month, 21).setDefaultInflow(635),
            Day.on(month, 22).setDefaultInflow(625),
            Day.on(month, 23).setDefaultInflow(525),
            Day.on(month, 24).setDefaultInflow(445),
            Day.on(month, 25).setDefaultInflow(440).setDefaultOutflow(300),
            // Day.on(feb, 26).setDefaultInflow(0),
            // Day.on(feb, 27).setDefaultInflow(0),
            Day.on(month, 28).setDefaultInflow(510),
            Day.on(month, 29).setDefaultInflow(390)
        );
    }
    
    public static void addJanData(Month month) {
        month.setDays(
            Day.on(month, 1).setDefaultInflow(335).setDefaultOutflow(100),
            Day.on(month, 2).setDefaultInflow(390),
            Day.on(month, 3).setDefaultInflow(425),
            Day.on(month, 4).setDefaultInflow(350).setDefaultOutflow(50),
            Day.on(month, 5).setDefaultInflow(305),
            Day.on(month, 6).setDefaultInflow(195).setDefaultOutflow(100),
            Day.on(month, 7).setDefaultInflow(485),
            Day.on(month, 8).setDefaultInflow(155),
            Day.on(month, 9).setDefaultInflow(275),
            Day.on(month, 10).setDefaultInflow(285).setDefaultOutflow(100),
            Day.on(month, 11).setDefaultInflow(360),
            Day.on(month, 12).setDefaultInflow(320),
            Day.on(month, 13).setDefaultInflow(445).setDefaultOutflow(300),
            Day.on(month, 14).setDefaultInflow(435),
            Day.on(month, 15).setDefaultInflow(320),
            Day.on(month, 16).setDefaultInflow(365),
            Day.on(month, 17).setDefaultInflow(225),
            Day.on(month, 18).setDefaultInflow(290),
            Day.on(month, 19).setDefaultInflow(180),
            Day.on(month, 20).setDefaultInflow(410),
            Day.on(month, 21).setDefaultInflow(110),
            Day.on(month, 22).setDefaultInflow(215).setDefaultOutflow(300),
            Day.on(month, 23).setDefaultInflow(110),
            Day.on(month, 24).setDefaultInflow(125),
            Day.on(month, 25).setDefaultInflow(485),
            Day.on(month, 26).setDefaultInflow(485),
            Day.on(month, 27).setDefaultInflow(650),
            Day.on(month, 28).setDefaultInflow(510),
            Day.on(month, 29).setDefaultInflow(190),
            Day.on(month, 30).setDefaultInflow(445).setDefaultOutflow(100),
            Day.on(month, 31).setDefaultInflow(425)
        );
    }

}
