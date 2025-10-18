package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;

public class NameServer {

/*Készíts egy dns.NameServer osztályt, amely, akárcsak egy domain name server,
listában tárolja, hogy milyen IP-címhez milyen domain név tartozik!
Legyen egy  DnsEntry nevű privát belső osztálya, amely egy név,
IP-cím párost tartalmaz és a NameServer osztály listája ilyen típusú adatokat
tartalmazzon!

Lehessen hozzáadni új név, IP-cím párost az addEntry(String hostName, String hostIp) metódussal,
ami dobjon IllegalArgumentException kivételt Already exists szöveggel, ha már van ilyen IP-cím, vagy név!
Lehessen törölni egy bejegyzést a nevet megadva a removeEntryByName metódussal,
ha nincs ilyen nevű, akkor ne történjen semmi!
Lehessen törölni IP-cím alapján, a removeEntryByIp metódussal!
Ha nincs ilyen IP-címmel rendelkező, akkor ne történjen semmi!
Lehessen megkapni az adott névhez tartozó IP-címet (getIpByName metódussal)!
A metódus dobjon IllegalArgumentException kivételt Element not found szöveggel, ha nincs ilyen!
Lehessen megkapni az adott ip-hez tartozó nevet (getNameByIp metódussal),
dobjon IllegalArgumentException kivételt Element not found szöveggel ha nincs ilyen!*/

    private final List<DnsEntry> dnsEntries = new ArrayList<>();

    public void addEntry(String hostName, String hostIp) {
        if(hostIpIsExisted(hostIp)||hostNameIsExisted(hostName)){
            throw new IllegalArgumentException("Already exists");
        }
        dnsEntries.add(new DnsEntry(hostName,hostIp));
    }

    public void removeEntryByName(String hostname){
        DnsEntry deletableDnsEntry = getDnsEntryByName(hostname);
        validateDnsEntry(deletableDnsEntry);
        dnsEntries.remove(deletableDnsEntry);
    }

    public void removeEntryByIp(String hostIp){
        validate(hostIp);
        DnsEntry deletableDnsEntry = getDnsEntryByIp(hostIp);
        validateDnsEntry(deletableDnsEntry);
        dnsEntries.remove(deletableDnsEntry);
    }

    public String getIpByName(String hostname){
        DnsEntry dnsEntry = getDnsEntryByName(hostname);
        validateDnsEntry(dnsEntry);
        return dnsEntry.getHostIp();
    }

    public String getNameByIp(String hostIp){
        DnsEntry dnsEntry = getDnsEntryByIp(hostIp);
        validateDnsEntry(dnsEntry);
        return dnsEntry.getHostName();
    }

    private static void validateDnsEntry(DnsEntry dnsEntry) {
        if(dnsEntry == null){
            throw new IllegalArgumentException("Element not found");
        }
    }

    public DnsEntry getDnsEntryByIp(String hostIp){
        validate(hostIp);
        DnsEntry result = null;
        for (DnsEntry dnsEntry : dnsEntries) {
            if(dnsEntry.getHostIp().equals(hostIp)){
                result = dnsEntry;
            }
        }
        return result;
    }

    public DnsEntry getDnsEntryByName(String hostName){
        validate(hostName);
        DnsEntry result = null;
        for (DnsEntry dnsEntry : dnsEntries) {
            if(dnsEntry.getHostName().equals(hostName)){
                result = dnsEntry;
            }
        }
        return result;
    }

    private void validate(String text){
        if(text == null || text.isBlank()){
            throw new IllegalArgumentException(text + " is missing.");
        }
    }

    private boolean hostIpIsExisted(String hostIp){
        validate(hostIp);
        for (DnsEntry dnsEntry : dnsEntries) {
            if(dnsEntry.hostIp.equals(hostIp)){
                return true;
            }
        }
        return false;
    }

    private boolean hostNameIsExisted(String hostname){
        validate(hostname);
        for (DnsEntry dnsEntry : dnsEntries) {
            if(dnsEntry.getHostName().equals(hostname)){
                return true;
            }
        }
        return false;
    }


    public class DnsEntry{
        private final String hostName;
        private final String hostIp;

        public DnsEntry(String hostName, String hostIp) {
            this.hostName = hostName;
            this.hostIp = hostIp;
        }

        public String getHostName() {
            return hostName;
        }

        public String getHostIp() {
            return hostIp;
        }
    }

}


