package com.soprasteria.terna.mymicroservice.utenti.codec;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class OffsetDateTimeCodec implements Codec<OffsetDateTime> {

    public static final String DATE_TIME = "dateTime";
    public static final String ZONE = "zone";

    @Override
    public void encode(final BsonWriter writer, final OffsetDateTime value, final EncoderContext encoderContext) {
        ZonedDateTime zdt = value.toZonedDateTime();
        writer.writeStartDocument();
        writer.writeDateTime(DATE_TIME, zdt.toInstant().getEpochSecond() * 1_000);
        writer.writeString(ZONE, zdt.getZone().getId());
        writer.writeEndDocument();
    }

    @Override
    public OffsetDateTime decode(final BsonReader reader, final DecoderContext decoderContext) {
        reader.readStartDocument();
        long epochSecond = reader.readDateTime(DATE_TIME);
        String zoneId = reader.readString(ZONE);
        reader.readEndDocument();
        return OffsetDateTime.ofInstant(Instant.ofEpochSecond(epochSecond / 1_000), ZoneId.of(zoneId));
    }

    @Override
    public Class<OffsetDateTime> getEncoderClass() {
        return OffsetDateTime.class;
    }
}
