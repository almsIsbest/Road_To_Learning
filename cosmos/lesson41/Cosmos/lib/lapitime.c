/**********************************************************
        文件管理API文件lapitime.c
***********************************************************
                彭东
**********************************************************/
#include "libtypes.h"
#include "libheads.h"


sysstus_t api_time(buf_t ttime)
{
    
    sysstus_t rets;
    API_ENTRY_PARE1(INR_TIME,rets,ttime);
    return rets;
}