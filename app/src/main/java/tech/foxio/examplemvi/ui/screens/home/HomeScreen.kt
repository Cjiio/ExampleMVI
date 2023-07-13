package tech.foxio.examplemvi.ui.screens.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import tech.foxio.examplemvi.MyApp.Companion.appContext
import tech.foxio.n2n.N2NService
import tech.foxio.n2n.model.N2NSettingInfo
import tech.foxio.n2n.model.N2NSettingModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val dataState by homeViewModel.dataState.collectAsState()
    val context = appContext
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                startVpnService(context)
            }
        }
    )

    Column {
        Text(text = dataState.data)
        Button(
            onClick = {
                val vpnPrepareIntent = VpnService.prepare(context)
                if (vpnPrepareIntent != null) {
                    launcher.launch(vpnPrepareIntent)
                } else {
                    // VPN 权限已授予
                    startVpnService(context)
                }
            }
        ) {
            Text(text ="Load Data")
        }
    }
}
fun startVpnService(context : Context) {
    val n2NSettingModel = N2NSettingModel()
    n2NSettingModel.id = 1
    n2NSettingModel.version = 3
    n2NSettingModel.name = "test"
    n2NSettingModel.ipMode = 1
    n2NSettingModel.ip = "0.0.0.0"
    n2NSettingModel.netmask = "255.255.255.0"
    n2NSettingModel.community = "test"
    n2NSettingModel.password = "test"
    n2NSettingModel.devDesc = "test"
    n2NSettingModel.superNode = "8.130.88.95:7777"
    n2NSettingModel.moreSettings = false
    n2NSettingModel.macAddr = "64:2c:a2:f6:02:ae"
    n2NSettingModel.mtu = 1386
    n2NSettingModel.holePunchInterval = 20
    n2NSettingModel.resoveSupernodeIP = false
    n2NSettingModel.localPort = 0
    n2NSettingModel.allowRouting = false
    n2NSettingModel.dropMuticast = true
    n2NSettingModel.useHttpTunnel = false
    n2NSettingModel.gatewayIp = ""
    n2NSettingModel.traceLevel = 2
    n2NSettingModel.isSelcected = true
    n2NSettingModel.encryptionMode = "AES-CBC"
    n2NSettingModel.headerEnc = false
    val n2NSettingInfo = N2NSettingInfo(n2NSettingModel)
    val intent = Intent(context, N2NService::class.java)
    val bundle = Bundle()

    bundle.putParcelable("n2nSettingInfo", n2NSettingInfo)
    intent.putExtra("Setting", bundle)

    context.startService(intent)
}
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}