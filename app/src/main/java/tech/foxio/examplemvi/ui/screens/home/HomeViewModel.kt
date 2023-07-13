package tech.foxio.examplemvi.ui.screens.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import com.blankj.utilcode.util.ServiceUtils.startService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import tech.foxio.n2n.N2NService
import tech.foxio.n2n.model.N2NSettingInfo
import tech.foxio.n2n.model.N2NSettingModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    @ActivityContext private val activityContext: Context,
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    private val _dataState = MutableStateFlow(DataState())
    val dataState: StateFlow<DataState>
        get() = _dataState

    fun sendUIIntent(homeIntent: HomeIntent) {
        when (homeIntent) {
            is HomeIntent.LoadData -> loadData()
        }
    }

    private fun loadData() {
//        //定义一个N2NSettingModel
//        val n2NSettingModel = N2NSettingModel()
//        n2NSettingModel.id = 1
//        n2NSettingModel.version = 3
//        n2NSettingModel.name = "test"
//        n2NSettingModel.ipMode = 0
//        n2NSettingModel.ip = "0.0.0.0"
//        n2NSettingModel.netmask = "255.255.255.0"
//        n2NSettingModel.community = "test"
//        n2NSettingModel.password = "test"
//        n2NSettingModel.devDesc = "test"
//        n2NSettingModel.superNode = "test"
//        n2NSettingModel.moreSettings = false
//        n2NSettingModel.macAddr = "64:2c:a2:f6:02:ae"
//        n2NSettingModel.mtu = 1386
//        n2NSettingModel.holePunchInterval = 20
//        n2NSettingModel.resoveSupernodeIP = false
//        n2NSettingModel.localPort = 0
//        n2NSettingModel.allowRouting = false
//        n2NSettingModel.dropMuticast = true
//        n2NSettingModel.useHttpTunnel = false
//        n2NSettingModel.traceLevel = 2
//        n2NSettingModel.isSelcected = true
//        n2NSettingModel.encryptionMode = "AES-CBC"
//        n2NSettingModel.headerEnc = false
//        val intent = Intent(activityContext, N2NService::class.java)
//        val bundle = Bundle()
//
//        val n2NSettingInfo = N2NSettingInfo(n2NSettingModel)
//        bundle.putParcelable("n2nSettingInfo", n2NSettingInfo)
//        intent.putExtra("Setting", bundle)
//
//        startService(intent)
    }
}