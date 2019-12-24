package com.isaacdeveloper.promofarmatest.modelBuilder

import com.isaacdeveloper.promofarmatest.domain.DomainState
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailDomainModel
import com.isaacdeveloper.promofarmatest.domain.model.ShowDetailResponseDomainModel

class MockBuilder {

    fun buildShowDetailResponseDomainModel() =
        ShowDetailResponseDomainModel(
            buildShowDetailDomainModel(),
            DomainState.SUCCESS
        )

    fun buildShowDetailDomainModel() =
        ShowDetailDomainModel(
            "1",
            "show_url",
            "show_name",
            "show_rating",
            "show_sinopsis"
        )
}