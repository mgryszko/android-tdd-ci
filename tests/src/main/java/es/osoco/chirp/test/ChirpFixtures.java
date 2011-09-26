package es.osoco.chirp.test;

import es.osoco.chirp.Chirp;

import java.util.List;

import static es.osoco.chirp.test.DateUtils.fromDatetimeStr;
import static java.util.Arrays.asList;

public class ChirpFixtures {
    static List<Chirp> mgryszkosChirps() {
        return asList(
            new Chirp("jamesshore",
                "Recording a new batch of #letsplaytdd videos. First should go up tomorrow.",
                fromDatetimeStr("2011-09-19 22:11:13")),
            new Chirp("rachelcdavies",
                "I spy with my little eye something beginning with F #boredonatrain",
                fromDatetimeStr("2011-09-19 19:22:59")),
            new Chirp("coreyhaines",
                "Last flight CVG-ORD Then cab and home!",
                fromDatetimeStr("2011-09-19 16:08:34")),
            new Chirp("coreyhaines",
                "Watched the @peepcode playbyplay with @rjs peepcode.com/products/ryan-… Fantastic. Great to see a flow in a different area than mine.",
                fromDatetimeStr("2011-09-19 16:01:02")),
            new Chirp("coreyhaines",
                "ZOMG CVG!",
                fromDatetimeStr("2011-09-19 14:29:00")),
            new Chirp("mgryszko",
                "my Ion Drum Rocker review -- I liked it a lot more than I thought I would. fakeplasticrock.com/2011/09/ion-dr…",
                fromDatetimeStr("2011-09-19 14:01:03")),
            new Chirp("mikewcohn",
                "New blog post on 'Seeing How Well a Team's Story Points Align' Completion time by point size bit.ly/qypsXf",
                fromDatetimeStr("2011-09-19 13:33:49")),
            new Chirp("codinghorror",
                "drobo? bah! real geeks build their own NAS! For cheaper! blog.superuser.com/2011/09/14/bui…",
                fromDatetimeStr("2011-09-19 13:27:56")),
            new Chirp("codinghorror",
                "accidentally fed @rockhardawesome a caffeinated drink today, trying to to estimate my #parentingfail energyfiend.com/death-by-caffe…",
                fromDatetimeStr("2011-09-19 12:44:00")),
            new Chirp("codinghorror",
                "codecademy.com is pretty nifty; interactive gamified JavaScript lessons",
                fromDatetimeStr("2011-09-19 12:05:12"))
        );
    }
}
