import es.osoco.chirp.Chirp
import java.text.SimpleDateFormat

class BootStrap {
    def init = { servletContext ->
        insertSampleChirps()

        Chirp.withTransaction {
        }
    }

    private insertSampleChirps() {
        sampleChirps().each {
            it.chirper = 'mgryszko'
            it.save()
        }
    }

    private sampleChirps() {
        [
            new Chirp(who: 'jamesshore',
                message: 'Recording a new batch of #letsplaytdd videos. First should go up tomorrow.',
                timestamp: fromDatetimeStr('2011-09-19 22:11:13')),
            new Chirp(who: 'rachelcdavies',
                message: 'I spy with my little eye something beginning with F #boredonatrain',
                timestamp: fromDatetimeStr('2011-09-19 19:22:59')),
            new Chirp(who: 'coreyhaines',
                message: 'Last flight CVG-ORD Then cab and home!',
                timestamp: fromDatetimeStr('2011-09-19 16:08:34')),
            new Chirp(who: 'coreyhaines',
                message: 'Watched the @peepcode playbyplay with @rjs peepcode.com/products/ryan-… Fantastic. Great to see a flow in a different area than mine.',
                timestamp: fromDatetimeStr('2011-09-19 16:01:02')),
            new Chirp(who: 'coreyhaines',
                message: 'ZOMG CVG!',
                timestamp: fromDatetimeStr('2011-09-19 14:29:00')),
            new Chirp(who: 'mgryszko',
                message: 'my Ion Drum Rocker review -- I liked it a lot more than I thought I would. fakeplasticrock.com/2011/09/ion-dr…',
                timestamp: fromDatetimeStr('2011-09-19 14:01:03')),
            new Chirp(who: 'mikewcohn',
                message: 'New blog post on \'Seeing How Well a Team\'s Story Points Align\' Completion time by point size bit.ly/qypsXf',
                timestamp: fromDatetimeStr('2011-09-19 13:33:49')),
            new Chirp(who: 'codinghorror',
                message: 'drobo? bah! real geeks build their own NAS! For cheaper! blog.superuser.com/2011/09/14/bui…',
                timestamp: fromDatetimeStr('2011-09-19 13:27:56')),
            new Chirp(who: 'codinghorror',
                message: 'accidentally fed @rockhardawesome a caffeinated drink today, trying to to estimate my #parentingfail energyfiend.com/death-by-caffe…',
                timestamp: fromDatetimeStr('2011-09-19 12:44:00')),
            new Chirp(who: 'codinghorror',
                message: 'codecademy.com is pretty nifty; interactive gamified JavaScript lessons',
                timestamp: fromDatetimeStr('2011-09-19 12:05:12')),
        ]
    }

    private fromDatetimeStr(String d) {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d)
    }

    def destroy = {
    }
}
