
import java.util.ArrayList;
import java.util.List;

public class VaultManager {

    public static List<Vault> vaults = new ArrayList<Vault>();
    public static Vault currentVault;

    public static Vault findVault(String name) {
        for (var v : vaults) {
            if (v.name == name) {
                return v;
            }
        }

        return null;
    }

    public static void setCurrentVault(String name) {
        for (var v : vaults) {
            if (v.name == name) {
                currentVault = v;
                return;
            }
        }
    }
}
