package com.isaacdeveloper.api.model.response.showsList

import com.isaacdeveloper.api.model.ResponseState
import com.isaacdeveloper.api.model.response.commonShowsModels.Data

class ShowsListApiResponseModel(
    var dataList: List<Data>?,
    var responseState: ResponseState
)