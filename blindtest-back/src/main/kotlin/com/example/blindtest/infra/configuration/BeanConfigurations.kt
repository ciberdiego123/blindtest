package com.example.blindtest.infra.configuration

import com.example.blindtest.domain.GuestRepository
import com.example.blindtest.domain.RoomRepository
import com.example.blindtest.domain.RoomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


@Configuration
class BeanConfigurations {

    @Bean
    fun roomService(roomRepository: RoomRepository, guestRepository: GuestRepository): RoomService {
        return RoomService(roomRepository, guestRepository)
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOrigin("http://localhost:4000") // Your frontend origin
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}
