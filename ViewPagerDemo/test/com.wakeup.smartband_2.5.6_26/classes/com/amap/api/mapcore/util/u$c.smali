.class public final enum Lcom/amap/api/mapcore/util/u$c;
.super Ljava/lang/Enum;
.source "GLMapResManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/api/mapcore/util/u;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "c"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amap/api/mapcore/util/u$c;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/amap/api/mapcore/util/u$c;

.field public static final enum b:Lcom/amap/api/mapcore/util/u$c;

.field private static final synthetic c:[Lcom/amap/api/mapcore/util/u$c;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 19
    new-instance v0, Lcom/amap/api/mapcore/util/u$c;

    const-string/jumbo v1, "DAY"

    invoke-direct {v0, v1, v2}, Lcom/amap/api/mapcore/util/u$c;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amap/api/mapcore/util/u$c;->a:Lcom/amap/api/mapcore/util/u$c;

    .line 20
    new-instance v0, Lcom/amap/api/mapcore/util/u$c;

    const-string/jumbo v1, "NIGHT"

    invoke-direct {v0, v1, v3}, Lcom/amap/api/mapcore/util/u$c;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amap/api/mapcore/util/u$c;->b:Lcom/amap/api/mapcore/util/u$c;

    .line 18
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amap/api/mapcore/util/u$c;

    sget-object v1, Lcom/amap/api/mapcore/util/u$c;->a:Lcom/amap/api/mapcore/util/u$c;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amap/api/mapcore/util/u$c;->b:Lcom/amap/api/mapcore/util/u$c;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amap/api/mapcore/util/u$c;->c:[Lcom/amap/api/mapcore/util/u$c;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amap/api/mapcore/util/u$c;
    .registers 2

    .prologue
    .line 18
    const-class v0, Lcom/amap/api/mapcore/util/u$c;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amap/api/mapcore/util/u$c;

    return-object v0
.end method

.method public static values()[Lcom/amap/api/mapcore/util/u$c;
    .registers 1

    .prologue
    .line 18
    sget-object v0, Lcom/amap/api/mapcore/util/u$c;->c:[Lcom/amap/api/mapcore/util/u$c;

    invoke-virtual {v0}, [Lcom/amap/api/mapcore/util/u$c;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amap/api/mapcore/util/u$c;

    return-object v0
.end method
