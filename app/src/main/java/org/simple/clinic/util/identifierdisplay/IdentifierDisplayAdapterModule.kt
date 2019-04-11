package org.simple.clinic.util.identifierdisplay

import android.content.res.Resources
import dagger.Module
import dagger.Provides
import org.simple.clinic.R
import org.simple.clinic.patient.businessid.Identifier.IdentifierType.BpPassport

@Module
class IdentifierDisplayAdapterModule {

  @Provides
  fun provideIdentifierDisplayAdapter(
      bpPassportTextConverter: BpPassportTextConverter,
      resources: Resources
  ): IdentifierDisplayAdapter {

    return IdentifierDisplayAdapter(
        converters = mapOf(
            BpPassport to bpPassportTextConverter
        ),
        unknownValueFallback = { it.value },
        unknownTypeFallback = { resources.getString(R.string.id) }
    )
  }
}
