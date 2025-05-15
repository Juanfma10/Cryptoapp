package com.example.cryptoapp.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.cryptoapp.models.Asset
import com.example.cryptoapp.ui.theme.Typography
import com.example.cryptoapp.viewModels.AssetsListViewModel


@Composable
fun AssetsList(viewModel: AssetsListViewModel = hiltViewModel()) {

    var assets = viewModel._assets.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.onBackground)
    ) {
//        items(assets) { asset ->
//            AssetRow(asset)
//        }
    }
}

@Composable
fun AssetRow(asset: Asset ){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier=Modifier.fillMaxWidth()
    ) {
        Box(
            modifier= Modifier.padding(vertical =8.dp)
        ){

        }
        /*
        Icon(imageVector= Icons.Filled.CheckCircle,
            contentDescription = null,
            tint= Color.Red
            )*/

        AsyncImage(
            model="https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
            contentDescription = null
        )


        Column {
            Text(text=asset.symbol,
                fontSize = 18.sp)
            Text(text=asset.name,
                fontSize = 18.sp)
        }

        Spacer(modifier=Modifier.weight(1f))


        /* Icon(
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = null,
            tint = Color.Green
        )*/

        Text(text= "${asset.percentage}%",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = if(asset.percentage>=0)Color.Green else Color.Red
            )

        Text(text="$${asset.price}",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }

}

@Preview(
    showBackground=true,
    showSystemUi=false
)

@Composable
fun AssetsListPreview() {
    com.example.cryptoapp.views.AssetsList()
}

@Composable
fun AssetRowPreview(){
Column (
    verticalArrangement = Arrangement.Center,
    modifier=Modifier.fillMaxSize()
) {
    AssetRow(Asset(
        id="1",
        name="Bitcoin",
        symbol="BTC",
        percentage= 5.38,
        price="87000",
    ))
            AssetRow(Asset(
        id="2",
        name="Bitcoin",
        symbol="BTC",
        percentage= -5.38,
        price="87000",
    ))

}
}

